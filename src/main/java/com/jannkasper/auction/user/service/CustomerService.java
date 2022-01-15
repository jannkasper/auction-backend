package com.jannkasper.auction.user.service;

import com.jannkasper.auction.user.entity.Customer;
import com.jannkasper.auction.user.repository.CustomerRepository;
import com.jannkasper.auction.user.web.request.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

  public Optional<Customer> findById(Integer customerId) {
    return repository.findById(customerId);
  }

  public List<Customer> findAll() {
    return repository.findAll();
  }

  public Customer save(CustomerRequest request) {
    return repository.save(Customer.createFrom(request));
  }

  public List<Customer> saveAll(Set<CustomerRequest> requests) {
    return repository.saveAll(requests.stream()
        .map(Customer::createFrom)
        .collect(Collectors.toSet())
    );
  }
}
