package com.javaquickstart.jacksonguava;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaquickstart.jacksonguava.web.TriviaClient;
import java.util.Base64;
import java.util.Base64.Decoder;

public class TriviaApplication {

  public static void main(String[] args) {

    final ObjectMapper mapper = new ObjectMapper();
    final TriviaClient client = new TriviaClient();
    final Decoder decoder = Base64.getDecoder();

    TriviaService triviaService = new TriviaService(mapper, client);

    final Questions questions = triviaService.getRandomQuestions(5);

    questions.getQuestions()
        .forEach(q -> System.out.println(q.getQuestion()));
  }



}
