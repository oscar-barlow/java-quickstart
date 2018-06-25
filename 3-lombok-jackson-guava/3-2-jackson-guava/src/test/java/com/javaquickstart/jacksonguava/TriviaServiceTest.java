package com.javaquickstart.jacksonguava;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TriviaServiceTest {

  @Mock
  private TriviaClient triviaClient;

  private TriviaService underTest;

  @Before
  public void setUp() {
    ObjectMapper objectMapper = new ObjectMapper();

    underTest = new TriviaService(objectMapper, triviaClient);
  }

  @Test
  public void shouldGetQuestionsFromTriviaApi() {
    // todo
  }

  @Test
  public void shouldThrowRuntimeExceptionGivenCallFails() {
    // todo
  }
}
