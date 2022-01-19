package com.jannkasper.security.user.repository;

import com.jannkasper.security.user.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

  private final CustomerJpaRepository repository;

  public Optional<Customer> findById(Integer customerId) {
    return repository.findById(customerId);
  }

  public List<Customer> findAll() {
    return repository.findAll();
  }

  public Customer save(Customer customer) {
    return repository.save(customer);
  }

  public List<Customer> saveAll(Set<Customer> customers) {
    return repository.saveAll(customers);
  }
}
