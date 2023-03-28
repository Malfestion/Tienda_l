/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda_l;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



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
    
    //cuales son los recursos protegidos y quienes pueden acceder
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/","/index","/errores/**","/webjars/**").permitAll()
                        .requestMatchers("/articulo/nuevo","articulo/guardar","/articulo/modificar/**","/articulo/eliminar/**",
                                "/categoria/nuevo","categoria/guardar","/categoria/modificar/**","/categoria/eliminar/**",
                                "/cliente/nuevo","cliente/guardar","/cliente/modificar/**","/cliente/eliminar/**").hasRole("ADMIN")
                        .requestMatchers("/articulo/listado",
                                "/categoria/lsitado",
                                "/cliente/listado").hasAnyRole("ADMIN","VENDEDOR")
                        
                )
                .formLogin((form)->form
                .loginPage("/login")
                .permitAll())
                .logout((logout)->logout.permitAll())
                .exceptionHandling()
                .accessDeniedPage("/errores/403");
        return http.build();
    }
}
