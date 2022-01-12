package com.jannkasper.auction.module.uaim.repository;

import com.jannkasper.auction.module.uaim.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

  private final CustomerJpaRepository repository;

  public List<Customer> findByEmail(String email) {
    return repository.findByEmail(email);
  }
}
