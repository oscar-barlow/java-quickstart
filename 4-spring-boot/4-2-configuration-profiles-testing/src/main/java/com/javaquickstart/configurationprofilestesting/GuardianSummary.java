package com.javaquickstart.configurationprofilestesting;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GuardianSummary {

  private final Response response;

  @Value
  @Builder
  public static class Response {
    private final List<NewsSummary> results;
  }

}
