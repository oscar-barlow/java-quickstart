package com.javaquickstart.debugginghandlingexceptions;

import java.io.IOException;

public class ErrorProneApplication {

  public static void main(String[] args) throws IOException {
    final DodgyWeatherService dodgyWeatherService = new DodgyWeatherService();
    final FileReader fileReader = new FileReader();
    final DodgyDataStore dodgyDataStore = new DodgyDataStore();

    dodgyWeatherService.getWeather("London");
    dodgyWeatherService.getWeather("Paris");

    String fileContents = fileReader.readFile("src/main/resources/example-text.txt");
    System.out.println(fileContents);
    fileReader.alternativeReadFile("non-existent-file.txt");

    dodgyDataStore.save("I sure hope this extremely important data gets saved!");
  }

}
