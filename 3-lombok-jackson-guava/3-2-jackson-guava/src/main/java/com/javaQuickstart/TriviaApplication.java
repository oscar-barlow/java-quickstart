package com.javaQuickstart;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class TriviaApplication {

  private static final ObjectMapper OBJECT_MAPPER  = new ObjectMapper();
  private static final TriviaClient TRIVIA_CLIENT = new TriviaClient();
  private static final TriviaService QUESTION_SERVICE = new TriviaService(TRIVIA_CLIENT, OBJECT_MAPPER);

  public static void main(String[] args) throws IOException {
//    QUESTION_SERVICE.getRandomQuestions(10);

    Person person = OBJECT_MAPPER.readValue("{\"name\" : \"mkyong\"}", Person.class);
    System.out.println(person.getName());

//    String questionJson = "{\"category\":\"Science & Nature\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which type of rock is created by intense heat AND pressure?\",\"correct_answer\":\"Metamorphic\",\"incorrect_answers\":[\"Sedimentary\",\"Igneous\",\"Diamond\"]}";
//    try {
//      Question question = OBJECT_MAPPER.readValue(questionJson, Question.class);
//      System.out.println(question.getQuestion());
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
  }

}
