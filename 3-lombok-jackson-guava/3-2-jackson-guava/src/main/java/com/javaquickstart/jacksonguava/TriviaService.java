package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TriviaService {

  private final ObjectMapper objectMapper;
  private final TriviaClient triviaClient;

  public Questions getRandomQuestions(int number) {
    try {
      String response = triviaClient.getRandomQuestions(number);
      Questions questions = objectMapper.readValue(response, Questions.class);
      return questions;
    } catch (Exception e) {
      throw new RuntimeException("Could not read response from trivia api: " + e);
    }
  }

}
