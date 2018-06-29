package com.javaQuickstart.streams;

import static java.util.Arrays.asList;

import com.javaQuickstart.streams.filtering.NameFilterer;
import com.javaQuickstart.streams.foreach.FireAndForgetRequest;
import com.javaQuickstart.streams.foreach.FireAndForgetter;
import com.javaQuickstart.streams.summing.IntegerSummer;
import com.javaQuickstart.streams.transforming.City;
import com.javaQuickstart.streams.transforming.CityTransformer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExamples {

  private static final IntegerSummer integerSummer = new IntegerSummer();
  private static final FireAndForgetter fireAndForgetter = new FireAndForgetter();
  private static final NameFilterer nameFilterer = new NameFilterer();
  private static final CityTransformer cityTransformer = new CityTransformer();

    public static void main(String[] args) {
      // Comment and uncomment the sections of code below so you can see which bit does what

      int[] simpleIntegers = new int[] {34, 99, 105, 1};
      int simpleTotal = integerSummer.sum(simpleIntegers);
      System.out.println("The sum is: " + simpleTotal);

//      List<Integer> integerArrayList = new ArrayList<Integer>(asList(64, 876, 99, 100));
//      int moreComplicatedTotal = integerSummer.sum(integerArrayList);
//      System.out.println("The sum is: " + moreComplicatedTotal);

//      FireAndForgetRequest fireAndForgetRequest1 = new FireAndForgetRequest(
//          "*** some important data 123 ***");
//      FireAndForgetRequest fireAndForgetRequest2 = new FireAndForgetRequest(
//          "*** more important data 456 ***");
//      List<FireAndForgetRequest> requests = asList(fireAndForgetRequest1, fireAndForgetRequest2);
//      fireAndForgetter.sendRequests(requests);

//      List<String> names = asList("Bob", "Yuki", "Manuela", "Tamara");
//      nameFilterer.shortNamesBeginningWithB(names);
//      nameFilterer.onlyJapaneseNames(names);

//      List<String> cityNames = asList("London", "Los Angeles", "Paris");
//      List<City> cities = cityNames.stream()
//          .map(cityTransformer)
//          .collect(Collectors.toList());
//      cities.forEach(c -> System.out.println(c.toString()));
    }


}
