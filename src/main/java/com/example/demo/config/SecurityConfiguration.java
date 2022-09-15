package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

<<<<<<< HEAD
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@Configuration
public class SecurityConfiguration {
    
    @Bean
    public
    WebSecurityCustomizer
    webSecurityCustomizer() {
        return (web) -> 
            web
                .ignoring()
                .antMatchers(
                    "/",
                    "/swagger-ui/**",
                    "/swagger-ui.html/**", 
                    "/docs/**");
=======
@Configuration
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SecurityConfiguration {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().antMatchers("/" , "/index");
>>>>>>> 6615d948c2448eeb15ee94a24e18ba07728e1e88
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
<<<<<<< HEAD
=======

>>>>>>> 6615d948c2448eeb15ee94a24e18ba07728e1e88
    }
}
