package com.github.illiaderhun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.github.illiaderhun")
public class DemoAppConfig {

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver theViewResolver = new InternalResourceViewResolver();

        theViewResolver.setPrefix("/WEB-INF/view/");
        theViewResolver.setSuffix(".jsp");

        return theViewResolver;
    }
}
