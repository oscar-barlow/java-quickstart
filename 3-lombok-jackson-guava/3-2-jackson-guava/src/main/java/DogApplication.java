import com.mashape.unirest.http.Unirest;
import java.io.IOException;

public class DogApplication {

  private static final BreedsService breedsService = new BreedsService();
  private static final DogClient dogClient = new DogClient();

  public static void main(String[] args) {

    dogClient.fetchRandomQuestions(10);
//    System.out.println(Joiner.on(", ").join(breeds));

//    List<String> withoutSubBreeds = breedsService.dogsWithoutSubBreeds();
//    List<String> withSubBreeds = breedsService.dogsWithSubBreeds();
//
//    System.out.println(format("Dogs without sub-breeds include: %s", Joiner.on(", ").join(withoutSubBreeds)));
////    System.out.println(format("Dogs with sub-breeds include: %s", Joiner.on(", ").join(withSubBreeds)));

    try {
      Unirest.shutdown();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // todo - load a csv
  // munge it with some stuff you get from the web
  // output it as json

}
