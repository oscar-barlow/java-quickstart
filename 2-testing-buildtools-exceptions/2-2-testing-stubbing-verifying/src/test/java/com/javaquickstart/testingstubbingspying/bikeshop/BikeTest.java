package com.javaquickstart.testingstubbingspying.bikeshop;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BikeTest {

  private Bike underTest;

  @Before
  public void setUp() throws Exception {
    underTest = new Bike();
  }

  @Test
  public void shouldWorkByDefault() throws Exception {
    assertTrue(underTest.isWorking());
  }
}
