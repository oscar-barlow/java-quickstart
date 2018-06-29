package com.javaquickstart.lombok;

import lombok.Getter;

public class Collie {

  @Getter
  private final String name;
  @Getter
  private final String noise;
  @Getter
  private final String ownerName;
  @Getter
  private final int age;
  @Getter
  private final float height;
  @Getter
  private final float weight;

  public Collie(String name, String noise, String ownerName, int age, float height,
      float weight) {
    this.name = name;
    this.noise = noise;
    this.ownerName = ownerName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}
