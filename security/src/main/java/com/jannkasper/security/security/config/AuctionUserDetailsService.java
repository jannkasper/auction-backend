package com.jannkasper.security.security.config;

import com.jannkasper.security.security.entity.SecurityCustomer;
import com.jannkasper.security.user.entity.Customer;
import com.jannkasper.security.user.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionUserDetailsService implements UserDetailsService {

  @Autowired
  private CustomerJpaRepository customerJpaRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<Customer> customer = customerJpaRepository.findByEmail(username);
    if (customer.size() == 0) {
      throw new UsernameNotFoundException("User details not found for the user : " + username);
    }
    return new SecurityCustomer(customer.get(0));
  }
}
