package com.jannkasper.auction.user.web.response;


import com.jannkasper.auction.user.entity.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter(value = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class CustomerResponse {

  private int id;
  private String email;
  private String role;

  public static CustomerResponse createFrom(Customer customer) {
    if (customer == null) {
      return null;
    }

    return new CustomerResponse()
        .setId(customer.getId())
        .setEmail(customer.getEmail())
        .setRole(customer.getRole());
  }
}
