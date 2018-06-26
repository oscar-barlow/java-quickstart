package com.javaquickstart.jacksonguava.web;

import static java.lang.String.format;

import com.google.common.collect.ImmutableMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class TriviaClient {

  private static final String TRIVIA_API_BASE_URL = "https://opentdb.com/api.php";

  public String getRandomQuestions(Integer number) {
    URL url = buildUrl(number);
    HttpURLConnection connection = openHttpConnection(url);

    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }

      in.close();
      connection.disconnect();

      return response.toString();
    } catch (IOException e) {
      throw new RuntimeException(format("Bad request", e));
    }
  }

  private URL buildUrl(Integer number) {
    try {
      Map<String, String> parameters = ImmutableMap.of("amount", number.toString());
      String urlString = TRIVIA_API_BASE_URL + "?" + ParameterStringBuilder.getParamsString(parameters);
      return new URL(urlString);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  private HttpURLConnection openHttpConnection(URL url) {
    try {
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      return connection;
    } catch (IOException e) {
      throw new RuntimeException("Bad connection");
    }
  }


}
