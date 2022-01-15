package com.jannkasper.auction.customer;

import com.jannkasper.auction.AbstractIntegrationTest;
import com.jannkasper.auction.user.repository.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CustomerRepositoryTest extends AbstractIntegrationTest {

  @Autowired
  protected CustomerRepository customerRepository;

  @Test
  @Transactional
  public void givenUsersWithSameNameInDB_WhenFindAllByName_ThenReturnStreamOfUsers() {
    Assertions.assertEquals(2, customerRepository.findAll().size());
  }

}
