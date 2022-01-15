package com.jannkasper.auction.user.repository;

import com.jannkasper.auction.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
  List<Customer> findByEmail(String email);
}
