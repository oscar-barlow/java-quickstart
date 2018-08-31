package com.javaquickstart.configurationprofilestesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TechnologyNewsService implements TechnologyNewsOperation {

  private final ObjectMapper mapper;
  private final GuardianNewsClient guardianNewsClient;

  @Override
  public List<String> getTechnologyHeadlines() {
    try {
      final Response response = guardianNewsClient.fetchTechnologyNews();
      final GuardianSummary guardianSummary = mapper
          .readValue(response.body().string(), GuardianSummary.class);

      return guardianSummary.getResponse().getResults().stream()
          .map(NewsSummary::getWebTitle)
          .collect(Collectors.toList());

    } catch (IOException e) {
      throw new RuntimeException("Could not retrieve headlines from Guardian API");
    }
  }
}
