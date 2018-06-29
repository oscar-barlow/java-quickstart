package com.javaQuickstart.optional;

import static java.util.Arrays.asList;

import java.util.List;

public class Application {

  private static final CityDetailsPrinter cityDetailsPrinter = new CityDetailsPrinter();

  public static void main(String[] args) {

    City london = new City("London");
    City la = new City("Los Angeles");
    City paris = new City("Paris");
    City tokyo = new City("Tokyo");

    List<City> cities = asList(london, la, paris, tokyo);

    cityDetailsPrinter.printDetails(cities);
  }
}
