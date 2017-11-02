package com.javaQuickstart.summing;

import java.util.List;
import java.util.stream.IntStream;

public class IntegerSummer {

  public IntegerSummer() {
  }

  public int sum(int[] integers) {
    IntStream intStream = IntStream.of(integers);
    return intStream.sum();
  }

  public int sum(List<Integer> integers) {
    return integers.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }

}
