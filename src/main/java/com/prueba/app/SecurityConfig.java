package com.prueba.app;

import com.prueba.app.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/history").access("hasRole('ADMIN')")
                    .antMatchers("/user/{id}").permitAll()
                    .antMatchers("/users").access("hasRole('ADMIN')");
    }

    @Autowired
    public void GlobalCofing(AuthenticationManagerBuilder builder) throws  Exception {
        builder.userDetailsService(userDetailsService);
    }
}
