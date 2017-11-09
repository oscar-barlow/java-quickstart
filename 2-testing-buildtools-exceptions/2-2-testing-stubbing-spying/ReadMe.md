# 2.2 Testing, Stubbing, and Spying

## Introduction
After completing this section, you should be able to write isolated unit tests for a Java class.

As you'll know from working with JavaScript, testing has a couple of different components. For example, if you're testing a node application, you might use [mocha](https://mochajs.org/) to run the tests, but write your assertions with [chai in BDD style](http://chaijs.com/api/bdd/), and install [simple-mock](https://github.com/jupiter/simple-mock) for your mocks.

The situation is similar when it comes to testing in Java. You'll need to select a **runner**, **matchers**, **assertions library**, and **mocking framework** to write meaningful tests for your classes.

But first, let's introduce a new feature of the Java language: annotations.

## Annotations
How does your test runner find your test methods? They're in the `test` directory, sure. But not every method in your test classes is a test; you've probably got some helper methods or classes in there too.

Back in the old days, you would have to do the arduous work of writing an XML file with all your test classes and methods in. But no longer.

Now, instead of writing xml, you use **annotations**. They look like this:

```java
@Test
public void shouldDoTheThingGivenSomeInput() {
  // test code goes here
}
``` 

In the example above, `@Test` is the annotation. It provides meta-information about your code - in this case, that the method is a test method. In this way, the annotation is a very convenient way to save a lot of time, what with all that xml you don't have to write.

Because they're so convenient, annotations are extremely widely used in Java, as we shall see in the coming chapters.

## Testing
Check out the classes in the `bikeshop` package, and the tests. IntelliJ contains a shortcut for switching back and forth between a class and its tests. Pressing cmd + shift + t (on a Mac) will toggle between them. Once you're in a test class, try using the generator menu (cmd + n) to get IntelliJ to autogenerate some useful stuff - setup methods, new test methods, and so on. This generator menu is often available, and can save you a good few keystrokes! 

Our `build.gradle` contains JUnit, and this is what will **run** our tests unless we specify otherwise. JUnit comes with some built-in **assertions** that we'll use, too.  

The tests for `Bike` are pretty trivial and ony use built-in JUnit functionality. But the tests for `BikeShop` need to be a little more complicated; we need to mock, stub, and spy here. 

## Mocking, Stubbing, and Spying
Far and away the most widely-used library for **mocking** in Java is Mockito. The tests for `BikeShop` contain a few examples of using Mockito. 

I'd like to highlight here that the **runner** on these tests has been changed to `MockitoJUnitRunner`, as you can see from the `@RunWith` annotation on the whole test class. This enables me to use the `@Mock` annotation to quickly and easily give myself a couple of mock `Bike`s. The alternative syntax for doing this is shown in `shouldReturnFalseGivenAtLeastOneBikeIsNotWorking()`. Both ways are pretty simple, so it's up to you which one to use. 

Finally, the `shouldRepairBrokenBikes()` test demonstrates the syntax for spying. Using Mockito, I can `verify` what methods (and - not demonstrated here - what arguments) are being passed to my mocks. I can also be sure that methods are *not* being called on my mocks, if I don't want them to be. In the case of `shouldRepairBrokenBikes()` I want to make sure that I'm not repairing any bikes that aren't broken, for example.  

## Mini-challenge
Use Gradle to add AssertJ to this project. AssertJ is an alternative **assertions** library for testing in Java. 

Right now we are using JUnit's assertions, but a lot of people find those pretty clunky. Refactor the test assertions to use AssertJ assertions instead.

Lastly, check out Hamcrest. Hamcrest is a large library of **matchers** - in other words, convenience methods for your tests that allow you to easily determine if a particular statement about a class/method under test is true, or if they have a particular quality. Hamcrest is probably a bit over-complicated for `bikeshop`, but it's useful to know about in any case.