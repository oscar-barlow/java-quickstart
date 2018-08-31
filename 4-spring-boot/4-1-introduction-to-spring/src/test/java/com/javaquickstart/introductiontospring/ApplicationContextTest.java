package com.javaquickstart.introductiontospring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@TestPropertySource(properties = "management.server.port=0")
public class ApplicationContextTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void showMeApplicationContext() {
    final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

    assertThat(beanDefinitionNames).isNotEmpty();
  }
}
