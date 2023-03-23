/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_l;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



/**
 *
 * @author aledu
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService users(){
        UserDetails admin=User.builder()
                .username("Juan")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .build();
        UserDetails sales=User.builder()
                .username("Rebeca")
                .password("{noop}456")
                .roles("VENDEDOR","USER")
               .build();
        UserDetails user=User.builder()
                .username("Pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
     return new InMemoryUserDetailsManager(user,sales,admin);
    }
}
