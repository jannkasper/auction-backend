package com.jannkasper.security;

import org.testcontainers.containers.PostgreSQLContainer;

public class IntegrationTestPostgresqlContainer extends PostgreSQLContainer<IntegrationTestPostgresqlContainer> {
  private static final String IMAGE_VERSION = "postgres:11-alpine";
  private static IntegrationTestPostgresqlContainer container;

  private IntegrationTestPostgresqlContainer() {
    super(IMAGE_VERSION);
    withDatabaseName("auction-backend");
    withUsername("ptsoftware");
    withPassword("Password123");
    withReuse(true);

  }

  public static IntegrationTestPostgresqlContainer getInstance() {
    if (container == null) {
      container = new IntegrationTestPostgresqlContainer();
    }

    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("spring.datasource.url", container.getJdbcUrl());
    System.setProperty("spring.datasource.password", container.getPassword());
    System.setProperty("spring.datasource.username", container.getUsername());
    System.setProperty("spring.jpa.show-sql", "true");
    System.setProperty("spring.flyway.enabled", "true");
    System.setProperty("spring.flyway.schemas", "active,flyway");
    System.setProperty("spring.flyway.default-schema", "flyway");
    System.setProperty("spring.flyway.user", "ptsoftware");
    System.setProperty("spring.flyway.password", "Password123");
    System.setProperty("spring.flyway.table", "version_history_auction-backend");
  }

  @Override
  public void stop() {
  }

}
