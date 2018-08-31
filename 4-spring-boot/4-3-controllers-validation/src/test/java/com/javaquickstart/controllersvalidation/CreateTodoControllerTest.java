package com.javaquickstart.controllersvalidation;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateTodoController.class)
public class CreateTodoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void shouldReturn200StatusCodeGivenValidCreateTodo() throws Exception {
    mockMvc.perform(post("/create").content(asJson(CreateTodo.builder()
        .title("Buy a pint of milk")
        .due(LocalDate.now())
        .description(
            "We just ran out and we'd like to have a tea party at the weekend. Remember to get semi-skimmed.")
        .build()))
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void shouldErrorGivenTitleMissing() throws Exception {
    mockMvc.perform(post("/create")
        .content(asJson(CreateTodo.builder()
        .due(LocalDate.now())
        .description(
            "We just ran out and we'd like to have a tea party at the weekend. Remember to get semi-skimmed.")
        .build()))
        .contentType(APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void shouldErrorGivenDueDateInPast() throws Exception {
    mockMvc.perform(post("/create").content(asJson(CreateTodo.builder()
        .title("Buy a pint of milk")
        .due(LocalDate.now().minusDays(1))
        .description(
            "We just ran out and we'd like to have a tea party at the weekend. Remember to get semi-skimmed.")
        .build()))
        .contentType(APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  private String asJson(Object o) {
    try {
      return mapper.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed to serialize object", e);
    }
  }
}
