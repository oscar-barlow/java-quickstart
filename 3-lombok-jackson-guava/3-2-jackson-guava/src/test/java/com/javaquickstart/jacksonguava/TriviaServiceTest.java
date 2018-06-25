package com.javaquickstart.jacksonguava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TriviaServiceTest {

  @Mock
  private TriviaClient triviaClient;

  private final ObjectMapper objectMapper = new ObjectMapper();

  private TriviaService underTest;

  @Before
  public void setUp() {
    underTest = new TriviaService(objectMapper, triviaClient);
  }

  @Test
  public void shouldGetQuestionsFromTriviaApi() {
    String response = "{\"response_code\":\"0\",\"results\":[{\"category\":\"Sport\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In which year did England win the world cup?\",\"correct_answer\":\"1966\",\"incorrect_answers\":[\"2000\",\"1978\",\"1994\",\"2014\"]}]}";
    given(triviaClient.getRandomQuestions(anyInt())).willReturn(response);

    assertThat(underTest.getRandomQuestions(1).getQuestions()).containsOnly(Question.builder()
        .category("Sport")
        .type("multiple")
        .difficulty("medium")
        .question("In which year did England win the world cup?")
        .correctAnswer("1966")
        .incorrectAnswers(ImmutableList.of("2000", "1978", "1994", "2014"))
        .build());
  }

  @Test
  public void shouldThrowRuntimeExceptionGivenCallFails() {
    given(triviaClient.getRandomQuestions(1)).willAnswer(i -> new IOException("Sorry, something failed"));

    assertThatThrownBy(() -> underTest.getRandomQuestions(1))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("Could not read response from trivia api");

  }
}
