package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaquickstart.jacksonguava.web.TriviaClient;

public class TriviaApplication {

  public static void main(String[] args) {

    final ObjectMapper mapper = new ObjectMapper();
    final TriviaClient client = new TriviaClient();

    TriviaService triviaService = new TriviaService(mapper, client);

    final Questions questions = triviaService.getRandomQuestions(5);

    questions.getQuestions()
        .stream()
        .forEach(q -> System.out.println(q.getQuestion()));
  }



}
