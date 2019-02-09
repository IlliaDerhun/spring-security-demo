package com.github.illiaderhun.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.illiaderhun")
@PropertySource("classpath:persistence-mysql.properties")
@EnableTransactionManagement
public class DemoAppConfig {

    @Autowired
    private Environment env;

    private final Logger LOGGER = Logger.getLogger(getClass().getSimpleName());

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver theViewResolver = new InternalResourceViewResolver();

        theViewResolver.setPrefix("/WEB-INF/view/");
        theViewResolver.setSuffix(".jsp");

        return theViewResolver;
    }

    @Bean(destroyMethod = "close")
    public DataSource securityDataSource() {
        ComboPooledDataSource thePool = new ComboPooledDataSource();

        try {
            thePool.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        thePool.setJdbcUrl(env.getProperty("jdbc.url"));
        thePool.setUser(env.getProperty("jdbc.user"));
        thePool.setPassword(env.getProperty("jdbc.password"));

        thePool.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        thePool.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        thePool.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        thePool.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return thePool;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean theSession = new LocalSessionFactoryBean();

        theSession.setDataSource(securityDataSource());
        theSession.setPackagesToScan("com.github.illiaderhun.entity");
        theSession.setHibernateProperties(getHibernateProperties());

        return theSession;
    }

    @Bean
    public HibernateTransactionManager myTransactionManager() {
        HibernateTransactionManager theManager = new HibernateTransactionManager();

        theManager.setSessionFactory(sessionFactory().getObject());

        return theManager;
    }

    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);

        Integer intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

    private Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();

        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.put("hibernate.show_sql", true);

        return hibernateProperties;
    }
}
