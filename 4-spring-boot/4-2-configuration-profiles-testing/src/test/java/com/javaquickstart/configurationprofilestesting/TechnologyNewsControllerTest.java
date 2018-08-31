package com.javaquickstart.configurationprofilestesting;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(TechnologyNewsController.class)
@TestPropertySource(properties = "management.server.port=0")
public class TechnologyNewsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TechnologyNewsOperation technologyNewsOperation;

  @Test
  public void shouldReturnHeadlines() throws Exception {
    given(technologyNewsOperation.getTechnologyHeadlines()).willReturn(ImmutableList.of("headline 1", "headline 2"));

    mockMvc.perform(get("/headlines"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasItems("headline 1", "headline 2")));
  }
}
