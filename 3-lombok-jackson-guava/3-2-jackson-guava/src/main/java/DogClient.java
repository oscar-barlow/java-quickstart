import static java.lang.String.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import java.io.IOException;
import java.util.List;

public class DogClient {

  private static final String DOG_API_BASE_URL = "https://dog.ceo/api";
  private static final String TRIVIA_API_BASE_URL = "https://opentdb.com/api.php";

  public DogClient() {
    Unirest.setObjectMapper(new ObjectMapper() {
      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
          = new com.fasterxml.jackson.databind.ObjectMapper();

      public <T> T readValue(String value, Class<T> valueType) {
        try {
          return jacksonObjectMapper.readValue(value, valueType);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      public String writeValue(Object value) {
        try {
          return jacksonObjectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  public Questions fetchRandomQuestions(Integer amount) {
    try {
      HttpResponse<Questions> response = Unirest.get(TRIVIA_API_BASE_URL)
          .queryString("amount", amount.toString())
          .asObject(Questions.class);
      return response.getBody();
    } catch (UnirestException e) {
      throw new RuntimeException(e);
    }
  }

  public List<String> fetchBreeds() {
    try {
      HttpResponse<List> response = Unirest.get(DOG_API_BASE_URL + "/breeds/list")
          .asObject(List.class);
      return response.getBody();
    } catch (UnirestException e) {
      throw new RuntimeException(e);
    }
  }

    public String fetchBreedsAsString() {
      try {
        HttpResponse<String> response = Unirest.get(DOG_API_BASE_URL + "/breeds/list")
            .asString();
        return response.getBody();
      } catch (UnirestException e) {
        throw new RuntimeException(e);
      }

    }

    public List<String> fetchSubBreeds(String breed) {
      try {
        HttpResponse<List> response = Unirest.get(format("%s/%s/list", DOG_API_BASE_URL, breed))
            .asObject(List.class);
        return response.getBody();
      } catch (UnirestException e) {
        throw new RuntimeException(e);
      }
    }

}
