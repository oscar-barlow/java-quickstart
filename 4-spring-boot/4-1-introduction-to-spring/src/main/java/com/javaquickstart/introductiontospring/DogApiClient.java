package com.javaquickstart.introductiontospring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class DogApiClient {

  private final ObjectMapper objectMapper;

  public DogApiClient(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  public DogImageUrl getRandomDogImage() {
    try {
      final HttpResponse<String> response = Unirest
          .get("https://dog.ceo/api/breeds/image/random")
          .asString();

      return objectMapper.readValue(response.getRawBody(), DogImageUrl.class);
    } catch (UnirestException e) {
      throw new RuntimeException("Could not get random dog image", e);
    } catch (IOException e) {
      throw new RuntimeException("Could not deserialise dog image payload response", e);
    }
  }

}
