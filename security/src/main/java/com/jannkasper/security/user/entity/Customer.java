package com.jannkasper.security.user.entity;

import com.jannkasper.security.user.web.request.CustomerRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers", schema = "active")
@Data
@Accessors(chain = true)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
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
