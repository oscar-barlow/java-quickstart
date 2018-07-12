package com.javaquickstart.introductiontospring;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;
import org.junit.Test;

public class DogApiClientTest {

  private final DogApiClient underTest = new DogApiClient(new ObjectMapper());

  @Test
  public void shouldGetRandomDogImage() {
    final DogImageUrl randomDogImage = underTest.getRandomDogImage();

    final Pattern jpegUrl = Pattern.compile("(?i)^.*.jpg$");

    assertThat(randomDogImage.getImageUrl()).containsPattern(jpegUrl);
  }
}
