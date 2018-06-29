package com.javaquickstart.springboot;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "management.server.port=0")
public class ApplicationTest {
  private RestOperations restOperations = new RestTemplate();

  @Autowired
  private ManagementServerProperties managementServerProperties;

  @Autowired
  private Environment environment;

  public String getManagementPath() {
    final int managementPort = environment.getProperty("local.management.port", Integer.class);
    final String managementPath = managementServerProperties.getServlet().getContextPath();

    return "http://localhost:" + managementPort + managementPath;
  }

  @Test
  public void healthCheck() throws Exception {
    assertThat(restOperations
        .getForEntity(UriComponentsBuilder
                .fromHttpUrl(getManagementPath() + "/health")
                .build()
                .toUri(),
            String.class).getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}
