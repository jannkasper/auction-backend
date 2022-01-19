package com.jannkasper.security.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
//        cors().configurationSource(new CorsConfigurationSource() {
//          @Override
//          public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//            CorsConfiguration config = new CorsConfiguration();
//            config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//            config.setAllowedMethods(Collections.singletonList("*"));
//            config.setAllowCredentials(true);
//            config.setAllowedHeaders(Collections.singletonList("*"));
//            config.setExposedHeaders(Arrays.asList("Authorization"));
//            config.setMaxAge(3600L);
//            return config;
//          }
//        }).and().csrf().disable()
//        .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
//        .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
//        .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
//        .authorizeRequests()
//        .antMatchers("/myAccount").authenticated()
//        .antMatchers("/myLoans").authenticated()
//        .antMatchers("/myBalance").authenticated()
//        .antMatchers("/myCards").authenticated()
//        .antMatchers("/notices").permitAll()
//        .antMatchers("/contact").permitAll()
//        .antMatchers("/health").permitAll()
//        .antMatchers("/version").permitAll()
//        .antMatchers("/nations").permitAll()
//        .antMatchers("/currencies").permitAll()
//        .antMatchers("/h2-console/*").permitAll()
//        .and().formLogin().and().httpBasic();
//
//    http.headers().frameOptions().disable();


    http.csrf().disable()
        .headers().frameOptions().disable()
        .and()
        .authorizeRequests().anyRequest().anonymous()
        .and()
        .httpBasic().disable();

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
    return NoOpPasswordEncoder.getInstance();
  }

}
