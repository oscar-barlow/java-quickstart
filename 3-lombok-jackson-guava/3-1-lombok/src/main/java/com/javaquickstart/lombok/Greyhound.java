package com.javaquickstart.lombok;

public class Greyhound {

  private String name;
  private String noise;
  private String ownerName;
  private int age;
  private float height;
  private float weight;

  public String getName() {
    return name;
  }

  public String getNoise() {
    return noise;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public int getAge() {
    return age;
  }

  public float getHeight() {
    return height;
  }

  public float getWeight() {
    return weight;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNoise(String noise) {
    this.noise = noise;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public Greyhound(String name, String noise, String ownerName, int age, float height,
      float weight) {
    this.name = name;
    this.noise = noise;
    this.ownerName = ownerName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}
