package com.jannkasper.security.user.web.api;

import com.jannkasper.security.user.entity.Customer;
import com.jannkasper.security.user.service.CustomerService;
import com.jannkasper.security.user.web.request.CustomerRequest;
import com.jannkasper.security.user.web.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomerApi {

  private final CustomerService customerService;

  @RequestMapping("/{id}")
  public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Integer customerId) {
    Customer customer = customerService.findById(customerId)
        .orElse(null);

    return ResponseEntity.ok(CustomerResponse.createFrom(customer));
  }

  @RequestMapping
  public ResponseEntity<List<CustomerResponse>> getCustomers() {
    List<Customer> customerList = customerService.findAll();

    return ResponseEntity.ok(customerList.stream()
        .map(CustomerResponse::createFrom)
        .collect(Collectors.toList())
    );
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
    Customer customer = customerService.save(request);

    return ResponseEntity.ok(CustomerResponse.createFrom(customer));
  }
}
