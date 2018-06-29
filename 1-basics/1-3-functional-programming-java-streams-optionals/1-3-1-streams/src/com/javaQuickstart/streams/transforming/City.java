package com.javaQuickstart.streams.transforming;

import static java.lang.String.format;

public class City {

  private final String name;
  private final String weather;
  private final double inhabitants;

  public City(String name, String weather, double inhabitants) {
    this.name = name;
    this.weather = weather;
    this.inhabitants = inhabitants;
  }

  public String getName() {
    return name;
  }

  public String getWeather() {
    return weather;
  }

  public double getInhabitants() {
    return inhabitants;
  }

  public String toString() {
    return format("Name: %s, Inhabitants: %s, Current weather: %s", getName(), getInhabitants(), getWeather());
  }
}
