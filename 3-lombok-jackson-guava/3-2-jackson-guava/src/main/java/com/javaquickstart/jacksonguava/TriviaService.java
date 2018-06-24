package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TriviaService {

  private final TriviaClient triviaClient;
  private final ObjectMapper objectMapper;

  public Questions getRandomQuestions(int number) {
    String response = triviaClient.getRandomQuestions(number);
    try {
      Questions questions = objectMapper.readValue(response, Questions.class);
      return questions;
    } catch (IOException e) {
      throw new RuntimeException("Could not read response from trivia api", e);
    }
  }

}
