import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableMap;
import com.javaQuickstart.ParameterStringBuilder;
import java.util.Map;
import org.junit.Test;

public class ParameterStringBuilderTest {

  @Test
  public void shouldBuildQueryParams() {
    Map<String, String> params = ImmutableMap.of("page", "0", "size", "20");
    String paramsString = ParameterStringBuilder.getParamsString(params);

    assertThat(paramsString).isEqualTo("page=0&size=20");
  }
}
