package com.javaQuickstart;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class TriviaApplication {

  public static void main(String[] args) throws IOException {

//    final TriviaClient triviaClient = new TriviaClient();
    final ObjectMapper objectMapper = new ObjectMapper();
//    final TriviaService questionService = new TriviaService(triviaClient,
//        objectMapper);

//    questionService.getRandomQuestions(10);

    Person person = objectMapper.readValue("{\"name\" : \"mkyong\"}", Person.class);
    System.out.println(person.getName());

    String questionJson = "{\"category\":\"Science & Nature\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which type of rock is created by intense heat AND pressure?\",\"correct_answer\":\"Metamorphic\",\"incorrect_answers\":[\"Sedimentary\",\"Igneous\",\"Diamond\"]}";
    try {
      Question question = objectMapper.readValue(questionJson, Question.class);
      System.out.println(question.getQuestion());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
