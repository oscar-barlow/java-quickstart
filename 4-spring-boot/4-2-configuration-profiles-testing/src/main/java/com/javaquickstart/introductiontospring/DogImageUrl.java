package com.javaquickstart.introductiontospring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DogImageUrl {

  @JsonIgnore
  private final String status;
  @JsonProperty("message")
  private final String imageUrl;

}
