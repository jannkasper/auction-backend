package com.jannkasper.auction.user.entity;

import com.jannkasper.auction.user.web.request.CustomerRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String pwd;
  private String role;

  public static Customer createFrom(CustomerRequest customerRequest) {
    return new Customer()
        .setEmail(customerRequest.getEmail())
        .setPwd(customerRequest.getPwd())
        .setRole(customerRequest.getRole());
  }
}
