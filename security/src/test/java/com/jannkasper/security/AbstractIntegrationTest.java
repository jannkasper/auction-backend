package com.jannkasper.security;

import org.junit.ClassRule;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public abstract class AbstractIntegrationTest {

  @ClassRule
  public static PostgreSQLContainer postgres;

  static {
    postgres = new PostgreSQLContainer<>("postgres:11-alpine")
        .withDatabaseName("auction-backend")
        .withUsername("ptsoftware")
        .withPassword("Password123")
        .withReuse(true);
    postgres.start();
  }

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues.of(
          "spring.datasource.url=" + postgres.getJdbcUrl(),
          "spring.datasource.username=" + postgres.getUsername(),
          "spring.datasource.password=" + postgres.getPassword(),
          "spring.jpa.show-sql=true",
          "spring.flyway.enabled=true",
          "spring.flyway.schemas=active,flyway",
          "spring.flyway.default-schema=flyway",
          "spring.flyway.user=ptsoftware",
          "spring.flyway.password=Password123",
          "spring.flyway.table=version_history_auction-backend"

      ).applyTo(configurableApplicationContext.getEnvironment());
    }
  }

//  @DynamicPropertySource
//  static void datasourceConfig(DynamicPropertyRegistry registry) {
//    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//    registry.add("spring.jpa.show-sql", () -> true);
//    registry.add("spring.flyway.enabled", () -> true);
//    registry.add("spring.flyway.schemas", () -> "active,flyway");
//    registry.add("spring.flyway.default-schema", () -> "flyway");
//    registry.add("spring.flyway.user", () -> "ptsoftware");
//    registry.add("spring.flyway.password", () -> "Password123");
//    registry.add("spring.flyway.table", () -> "version_history_auction-backend");
//  }
}
