import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Chihuahua {

  private final String name;
  private final String noise;
  private final String ownerName;
  private final int age;
  private final float height;
  private final float weight;

}
