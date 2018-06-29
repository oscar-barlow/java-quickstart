package com.javaQuickstart.optional;

import java.util.List;

public class CityDetailsPrinter {

  private static final CityInhabitantsLookUp cityInhabitantsLookUp = new CityInhabitantsLookUp();

  public CityDetailsPrinter() {
  }

  public void printDetails(List<City> cities) {
    cities.forEach(city -> {
      city.setInhabitants(cityInhabitantsLookUp.lookUp(city.getName()));
      System.out.println(city.toString());
    });
  }
}
