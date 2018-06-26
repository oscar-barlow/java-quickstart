package com.javaquickstart.jacksonguava;

import com.google.common.collect.ImmutableMap;
import com.javaquickstart.jacksonguava.web.ParameterStringBuilder;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ParameterStringBuilderTest {


  @Test
  public void shouldBuildQueryParams() {
    Map<String, String> params = ImmutableMap.of("page", "0", "size", "20");
    String paramsString = ParameterStringBuilder.getParamsString(params);

    Assertions.assertThat(paramsString).isEqualTo("page=0&size=20");
  }
}
