package com.mikellbobadilla.login_thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


  private final AuthenticationProvider authProvider;

  public SecurityConfig(AuthenticationProvider authProvider){
    this.authProvider = authProvider;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{

    http
      .authorizeHttpRequests()
      .requestMatchers("/login","/register")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .authenticationProvider(authProvider)
      .formLogin()
      .loginPage("/login");

    return http.build();
  }
}
