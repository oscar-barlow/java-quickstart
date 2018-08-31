package com.javaquickstart.configurationprofilestesting;

import static java.time.ZoneOffset.UTC;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = NONE)
@TestPropertySource(properties = "management.server.port=0")
public class ObjectMapperTest {

  public static final ZonedDateTime NOW = ZonedDateTime.now(UTC);

  @Autowired
  private ObjectMapper configuredObjectMapper;

  @Test
  public void serialisesDateTimeAsHumanReadableTimeStamp() throws JsonProcessingException {
    final String asString = configuredObjectMapper.writeValueAsString(NOW);
    System.out.println(asString);
  }

  @Test
  public void serialisesDateTimeAsLongJsonObject() throws JsonProcessingException {
    final ObjectMapper defaultMapper = new ObjectMapper();
    final String asString = defaultMapper.writeValueAsString(NOW);
    System.out.println(asString);
  }
}
