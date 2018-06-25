package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TriviaApplication {

  public static void main(String[] args) {

    ObjectMapper mapper = new ObjectMapper();
    TriviaClient client = new TriviaClient();

    TriviaService triviaService = new TriviaService(mapper, client);

    final Questions questions = triviaService.getRandomQuestions(5);

    questions.getQuestions()
        .forEach(System.out::println);
  }



}
