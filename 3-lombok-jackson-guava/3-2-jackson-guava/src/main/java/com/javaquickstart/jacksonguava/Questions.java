package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Questions {

  @JsonProperty("response_code")
  private final String responseCode;
  @JsonProperty("results")
  private final List<Question> questions;

}
