package com.jannkasper.auction.config;

import com.jannkasper.auction.module.uaim.model.Customer;
import com.jannkasper.auction.module.uaim.model.SecurityCustomer;
import com.jannkasper.auction.module.uaim.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionUserDetailsService implements UserDetailsService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<Customer> customer = customerRepository.findByEmail(username);
    if (customer.size() == 0) {
      throw new UsernameNotFoundException("User details not found for the user : " + username);
    }
    return new SecurityCustomer(customer.get(0));
  }
}
