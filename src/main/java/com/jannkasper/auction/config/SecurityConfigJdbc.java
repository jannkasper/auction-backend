package com.jannkasper.auction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigJdbc extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .antMatchers("/myAccount").authenticated()
        .antMatchers("/myLoans").authenticated()
        .antMatchers("/myBalance").authenticated()
        .antMatchers("/myCards").authenticated()
        .antMatchers("/notices").permitAll()
        .antMatchers("/contact").permitAll()
        .antMatchers("/h2-console/*").permitAll()
        .and().formLogin().and().httpBasic();

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(this.userDetailsService());
  }

  @Autowired
  public DataSource dataSource;

  @Override
  public UserDetailsService userDetailsService() {
    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
    return NoOpPasswordEncoder.getInstance();
  }

}
