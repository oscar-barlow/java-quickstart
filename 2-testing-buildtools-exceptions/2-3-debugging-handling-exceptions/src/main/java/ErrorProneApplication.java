import java.io.IOException;

public class ErrorProneApplication {

  private static final DodgyWeatherService dodgyWeatherService = new DodgyWeatherService();
  private static final FileReader fileReader = new FileReader();
  private static final DodgyDataStore dodgyDataStore = new DodgyDataStore();

  public static void main(String[] args) throws IOException {
    dodgyWeatherService.getWeather("London");
    dodgyWeatherService.getWeather("Paris");

    String fileContents = fileReader.readFile("example-text.txt");
    System.out.println(fileContents);
    fileReader.alternativeReadFile("non-existent-file.txt");

    dodgyDataStore.save("I sure hope this extremely important data gets saved!");
  }

}
