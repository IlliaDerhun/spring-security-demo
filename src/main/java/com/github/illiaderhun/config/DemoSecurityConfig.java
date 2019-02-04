package com.github.illiaderhun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
            .withUser(users.username("John").password("123").roles("EMPLOYEE"))
            .withUser(users.username("Mary").password("123").roles("MANAGER"))
            .withUser(users.username("Susan").password("123").roles("ADMIN"));
    }
}
