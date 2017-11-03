package com.javaQuickstart;

import java.util.HashMap;
import java.util.Optional;

public class CityInhabitantsLookUp {

  private static final HashMap<String, String> cityInhabitants = new HashMap<String, String>() {
    {
      put("London", "8788000");
      put("Los Angeles", "3796000");
      put("Paris", "2244000");
    }
  };

  public Optional<String> lookUp(String cityName) {
    return Optional.ofNullable(cityInhabitants.get(cityName));
  }


}
