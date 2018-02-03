package com.javaQuickstart;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {

  private final String name;

}
