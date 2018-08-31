package com.javaquickstart.configurationprofilestesting;

import static java.lang.String.format;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GuardianNewsClient {

  private final OkHttpClient okHttpClient;
  private final String apiKey;

  private static final String GUARDIAN_TECH_NEWS_BASE_URL = "https://content.guardianapis.com/search?section=technology";

  public GuardianNewsClient(OkHttpClient okHttpClient,
      @Value("${application.guardian-api-key}") String apiKey) {
    this.okHttpClient = okHttpClient;
    this.apiKey = apiKey;
  }


  public Response fetchTechnologyNews() throws IOException {
    final String url = GUARDIAN_TECH_NEWS_BASE_URL + format("&api-key=%s", apiKey);
    final Request request = new Builder()
        .url(url)
        .build();

      return okHttpClient.newCall(request).execute();
  }

}
