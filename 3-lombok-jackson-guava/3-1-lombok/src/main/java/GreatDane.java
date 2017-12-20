public class GreatDane {

  private final String name;
  private final String noise;
  private final String ownerName;
  private final int age;
  private final float height;
  private final float weight;

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

  public String getName() {
    return name;
  }

  public GreatDane(String name, String noise, String ownerName, int age, float height,
      float weight) {
    this.name = name;
    this.noise = noise;
    this.ownerName = ownerName;
    this.age = age;
    this.height = height;
    this.weight = weight;
  }
}
