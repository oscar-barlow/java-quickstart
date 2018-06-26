package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Question {

  private String category;
  private String type;
  private String difficulty;
  private String question;

  @JsonProperty("correct_answer")
  private String correctAnswer;

  @JsonProperty("incorrect_answers")
  private List<String> incorrectAnswers;

}
