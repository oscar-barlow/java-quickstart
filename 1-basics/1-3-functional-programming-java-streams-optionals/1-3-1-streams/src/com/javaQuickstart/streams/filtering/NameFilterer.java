package com.javaQuickstart.streams.filtering;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;

public class NameFilterer {

  public NameFilterer() {
  }

  public List<String> shortNamesBeginningWithB(List<String> names) {
    List<String> shortNames = names.stream()
        .filter(n -> n.length() < 5)
        .filter(n -> n.startsWith("B"))
        .collect(toList());

    System.out.println(shortNames);

    return shortNames;
  }

  public List<String> onlyJapaneseNames(List<String> names) {
    List<String> japaneseNames = names.stream()
        .filter(isJapaneseName())
        .collect(toList());

    System.out.println(japaneseNames);

    return japaneseNames;
  }

  public static Predicate<String> isJapaneseName() {
    final List<String> japaneseNames = asList("Haruto", "Reo", "Aoi", "Yuki");

    return p -> japaneseNames.contains(p);
  }
}
