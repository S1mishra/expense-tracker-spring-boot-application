package com.example.expensetracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Enable Spring Security's web security support
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //This was introduced because without this H2 console was not accessible, as Spring Security by default secures all endpoints.
    //We were being aksed username and password and not being directed to h2-console : http://localhost:8080/h2-consol (provide jdbc url 
    // as jdbc:h2:mem:testdb (as mentioned in application.yml) and username as sa and leave password blank..we will be able to view our 
    // table populated with data.sql)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().csrf().disable().headers().frameOptions().disable();

        return http.build();

    }
}
