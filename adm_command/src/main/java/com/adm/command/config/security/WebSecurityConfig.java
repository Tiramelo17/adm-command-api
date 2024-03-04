package com.adm.command.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
          .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                  authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                          .requestMatchers("/login/create").hasAnyRole("ADMIN","admin")
                          .requestMatchers("/item/create").hasAnyRole("ADMIN","admin")
                          .requestMatchers("/pedido/create").hasAnyRole("ADMIN","admin","user","USER")
                          .requestMatchers("/pedido/update").hasAnyRole("ADMIN","admin","user","USER")
                          .requestMatchers("/login").permitAll()
                          .requestMatchers("/item").permitAll()
                          .requestMatchers("/pedido").permitAll()
                          .anyRequest().authenticated())
          .httpBasic(Customizer.withDefaults())
          .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    
  
    
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
          .password(bCryptPasswordEncoder.encode("userPass"))
          .roles("USER")
          .build());
        manager.createUser(User.withUsername("admin")
          .password(bCryptPasswordEncoder.encode("adminPass"))
          .roles("USER", "ADMIN")
          .build());
        return manager;
    }
    
    
    
}