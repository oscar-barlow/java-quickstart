package com.javaQuickstart;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Question {

  @JsonProperty("category")
  private String category;

  @JsonProperty("type")
  private String type;

  @JsonProperty("difficulty")
  private String difficulty;

  @JsonProperty("question")
  private String question;

  @JsonProperty("correct_answer")
  private String correctAnswer;

  @JsonProperty("incorrect_answers")
  private List<String> incorrectAnswers;

}
