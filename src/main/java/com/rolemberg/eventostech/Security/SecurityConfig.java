package com.rolemberg.eventostech.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends DelegatingWebMvcConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests((http) ->
                http.anyRequest().permitAll()
            )
            .build();
    }
}
