package com.javaquickstart.configurationprofilestesting;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpClientConfiguration {

  @Bean
  public OkHttpClient okHttpClient() {
    return new OkHttpClient();
  }

}
