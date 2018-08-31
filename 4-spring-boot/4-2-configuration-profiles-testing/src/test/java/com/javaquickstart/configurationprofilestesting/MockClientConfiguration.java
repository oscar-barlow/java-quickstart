package com.javaquickstart.configurationprofilestesting;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mocked-client")
public class MockClientConfiguration {

  @Bean
  @Primary
  public GuardianNewsClient guardianNewsClient() {
    return mock(GuardianNewsClient.class);
  }

}
