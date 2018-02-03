package com.javaQuickstart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

public class Person {

  public String getName() {
    return name;
  }

  @JsonCreator
  public Person(String name) {
    this.name = name;
  }

  public String name;

}
