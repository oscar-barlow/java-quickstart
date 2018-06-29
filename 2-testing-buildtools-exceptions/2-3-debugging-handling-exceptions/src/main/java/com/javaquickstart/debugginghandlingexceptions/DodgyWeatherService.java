package com.javaquickstart.debugginghandlingexceptions;

public class DodgyWeatherService {

  public String getWeather(String cityName) {
    if (cityName.equals("London")) {
      return "Cold, rainy and cloudy";
    } else {
      throw new RuntimeException("Could not find city name");
    }
  }

}
