package com.javaquickstart.configurationprofilestesting;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NewsSummary {

  private final String webTitle;

}
