import lombok.Value;

@Value
public class Collie {

  private final String name;
  private final String noise;
  private final String ownerName;
  private final int age;
  private final float height;
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
