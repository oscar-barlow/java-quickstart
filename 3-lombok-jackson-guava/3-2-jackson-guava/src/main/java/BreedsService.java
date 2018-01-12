import static java.util.stream.Collectors.toList;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;

public class BreedsService {

  private final DogClient dogClient = new DogClient();

//  public List<String> dogsWithoutSubBreeds() throws UnirestException {
//    List breeds = dogClient.fetchBreeds();
//    return breeds.getMessage().stream()
//        .filter(breed -> {
//          Breeds subBreeds = dogClient.fetchSubBreeds(breed);
//          return subBreeds.getMessage().isEmpty();
//        })
//        .collect(toList());
//  }
//
//  public List<String> dogsWithSubBreeds() throws UnirestException {
//    List breeds = dogClient.fetchBreeds();
//    return breeds.getMessage().stream()
//        .filter(breed -> {
//          Breeds subBreeds = dogClient.fetchSubBreeds(breed);
//          return !subBreeds.getMessage().isEmpty();
//        })
//        .collect(toList());
//  }

}
