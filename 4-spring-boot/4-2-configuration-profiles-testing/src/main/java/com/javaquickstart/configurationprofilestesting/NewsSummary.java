package com.javaquickstart.configurationprofilestesting;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NewsSummary {

  private final String id;
  private final String type;
  private final String sectionId;
  private final String sectionName;
  private final ZonedDateTime webPublicationDate;
  private final String webTitle;
  private final String webUrl;
  private final String apiUrl;
  private final Boolean isHosted;
  private final String pillarId;
  private final String pillarName;

}
