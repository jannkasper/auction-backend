package com.jannkasper.auction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().ignoringAntMatchers("/contact", "/notices", "/h2-console/*")
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and().authorizeHttpRequests()
        .antMatchers("/myAccount").authenticated()
        .antMatchers("/myLoans").authenticated()
        .antMatchers("/myBalance").authenticated()
        .antMatchers("/myCards").authenticated()
        .antMatchers("/notices").permitAll()
        .antMatchers("/contact").permitAll()
        .antMatchers("/h2-console/*").permitAll()
        .and().formLogin().and().httpBasic();

    http.headers().frameOptions().disable();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    return new CorsConfigurationSource() {
      @Override
      public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);
        return config;
      }
    };
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
//    return NoOpPasswordEncoder.getInstance();
  }

}
