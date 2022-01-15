package com.jannkasper.auction;

import com.jannkasper.auction.app.web.api.AppController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DataControllerTest {

  @Autowired
  AppController appController;

  @Test
  void health() {
    assertEquals( "HEALTH CHECK OK!", appController.healthCheck());
  }

  @Test
  void version() {
    assertEquals( "The actual version is 1.0.0", appController.version());
  }

  @Test
  void nationsLength() {
    Integer nationsLength = appController.getRandomNations().size();
    assertEquals(10, nationsLength);
  }

  @Test
  void currenciesLength() {
    Integer currenciesLength = appController.getRandomCurrencies().size();
    assertEquals(20, currenciesLength);
  }

}
