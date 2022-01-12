package com.jannkasper.auction.module.uaim.repository;

import com.jannkasper.auction.module.uaim.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
  List<Customer> findByEmail(String email);
}
