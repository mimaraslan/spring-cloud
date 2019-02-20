package com.mimaraslan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//OR
//@EnableGlobalMethodSecurity(
//prePostEnabled = true, 
//securedEnabled = true, 
//jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
//    	http.csrf().disable()
//        	.authorizeRequests()
//        	.antMatchers(HttpMethod.POST, "/encrypt/**").permitAll();
    
    	// POST
    	// http://localhost:8888/encrypt
    	// http://localhost:8888/decrypt
    	http
        .csrf().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
   }
 
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
       .withUser("katerina")
       .password("{noop}123456789").roles("ADMIN");

   }
}