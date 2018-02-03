package com.javaQuickstart;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Questions {

  @JsonProperty("results")
  private List<Question> questions;

}
