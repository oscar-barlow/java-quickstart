package com.javaquickstart.configurationprofilestesting;

import static java.lang.String.format;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TechnologyNewsService implements TechnologyNewsOperation {

  private final OkHttpClient okHttpClient;
  private final ObjectMapper mapper;

  @Value("${application.guardian-api-key}")
  private final String apiKey;

  private static final String GUARDIAN_TECH_NEWS_BASE_URL = "https://content.guardianapis.com/search?sectionName=technology";

  @Override
  public List<String> getHeadlines() {
    final Response response = fetchNews();
    try {
      final GuardianSummary guardianSummary = mapper
          .readValue(response.body().byteStream(), GuardianSummary.class);

      return guardianSummary.getResponse().getResults().stream()
          .map(NewsSummary::getWebTitle)
          .collect(Collectors.toList());

    } catch (IOException e) {
      throw new RuntimeException("Could not deserialise results from Guardian API");
    }
  }

  private Response fetchNews() {
    final Request request = new Builder()
        .url(GUARDIAN_TECH_NEWS_BASE_URL + format("&api-key=%s", apiKey))
        .build();

    try {
      return okHttpClient.newCall(request).execute();
    } catch (IOException e) {
      throw new RuntimeException("could not complete request to Guardian API");
    }
  }
}
