package com.javaQuickstart.transforming;

import java.util.function.Function;

public class CityTransformer implements Function<String, City> {

  public CityTransformer() {
  }

  @Override
  public City apply(String cityName) {
    return new City(cityName, weather(cityName), inhabitants(cityName));
  }

  private String weather(String cityName) {
    if (cityName == "London") {
      return "cloudy";
    } else if (cityName == "Los Angeles") {
      return "sunny";
    } else {
      return "dunno!";
    }
  }

  private double inhabitants(String cityName) {
    if (cityName == "London") {
      return 8788000d;
    } else if (cityName == "Los Angeles") {
      return 3796000d;
    } else {
      return 2244000d;
    }
  }

}
