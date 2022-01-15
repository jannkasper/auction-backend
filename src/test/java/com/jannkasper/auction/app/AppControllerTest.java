package com.jannkasper.auction.app;

import com.jannkasper.auction.app.web.api.AppController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppControllerTest {

  protected AppController appController = new AppController();

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
