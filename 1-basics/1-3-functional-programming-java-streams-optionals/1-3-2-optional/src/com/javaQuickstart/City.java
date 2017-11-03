package com.javaQuickstart;

import static java.lang.String.format;

import java.util.Optional;

public class City {

  private final String name;
  private Optional<String> inhabitants;

  public City(String name) {
    this.name = name;
  }

  public void setInhabitants(Optional inhabitants) {
    this.inhabitants = inhabitants;
  }

  public String getName() {
    return name;
  }

  public String getInhabitants() {
    return inhabitants.orElse("an unknown number of");
  }

  public String toString() {
    return format("%s has %s inhabitants", getName(), getInhabitants());
  }
}
