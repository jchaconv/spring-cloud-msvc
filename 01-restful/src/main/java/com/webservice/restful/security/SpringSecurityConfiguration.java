package com.webservice.restful.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //All request should be authenticated
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        //If a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(withDefaults());

        //CSRF -> POST, PUT
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
