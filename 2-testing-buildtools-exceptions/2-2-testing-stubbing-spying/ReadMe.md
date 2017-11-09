# 2.2 Testing, Stubbing, and Spying

## Introduction
After completing this section, you should be able to write isolated unit tests for a Java class.

As you'll know from working with JavaScript, testing has a couple of different components. For example, if you're testing a node application, you might use [mocha](https://mochajs.org/) to run the tests, but write your assertions [chai in BDD style](http://chaijs.com/api/bdd/), and install [simple-mock](https://github.com/jupiter/simple-mock) for your mocks.

It's very similar in Java - you'll need to select a runner, matchers, and mocking framework to write meaningful tests for your classes.

But first, let's introduce a new feature of the Java language: annotations.

## Annotations
How does your test runner find your test methods? They're in the `test` directory, sure. But not every method in your test classes is a test; you've probably got some helper methods or classes in there too.

Back in the old days, you would have to do the arduous work of writing an XML file with all your test classes and methods in. But no longer.

Now, instead of writing xml, you use **annotations**. They look a bit like this:

```java
@Test
public void shouldDoTheThingGivenSomeInput() {
  // test code goes here
}
``` 

In the example above, `@Test` is the annotation. It provides meta-data about your code - in this case, that the method is a test method. In this way, the annotation is a very convenient way to save a lot of time, what with all that xml you don't have to write.

Because they're so convenient, annotations are extremely widely used in Java, as we shall see in the coming chapters.

## Mocking, Stubbing, and Spying
IntelliJ contains a shortcut for switching back and forth between a class and its tests. Pressing cmd + shift + t on a Mac will toggle between them. Once you're in a test class, you can use the generator menu (cmd + n) to get IntelliJ to autogenerate some useful stuff - setup methods, new test methods, and so on. This menu is usually available at cmd + n and can save you a good few keystrokes!

Check out the classes in the `bikeshop` package, and the tests. The tests for `Bike` are pretty trivial. But the tests for `BikeShop` need to be a little more complicated; we need to mock, stub, and spy here. 

The syntax for doing this is show in the tests for `BikeShop`. I'd also like to highlight here, that I've changed the **runner** on these tests to be the `MockitoJUnitRunner`, using an annotation on the test class. This enables me to use teh `@Mock` annotation to quickly and easily give myself a couple of mock `Bike`s. The alternative syntax for doing this is shown in `shouldReturnFalseGivenAtLeastOneBikeIsNotWorking()`. Both ways are pretty simple, so it's up to you which one to use.

  

alternative test runners
assertj and hamcrest
mocking
stubbing
spying