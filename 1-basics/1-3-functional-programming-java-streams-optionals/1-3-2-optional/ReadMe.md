# 1.3.2 Optional

## Introduction
We're almost done with our tour of basic Java features. There's just one more thing I'd like to show you before we move on: `Optional`s.

## Stop (checking for) null
If you've been playing around with the example projects in this course, or perhaps on a site like codewars, you've probably hit a `NullPointerException`. Java was expecting to find a value, but instead found nothing, and as a result your program produced an error.

If you go to IntelliJ and press Cmd + O, then type 'NullPointerException', then press Enter, you'll be brought to the definition of the `NullPointerException` class. You can find here a partial list of things that cause ('throw') this exception.

Now, exceptions are pretty useful when we're debugging - they give us good information about the source of the problem. But we don't want to be throwing exceptions in the normal course of running our app, so we'd better figure out a way of stopping them from getting thrown.

Let's borrow our `City` class from the prevous section, with one change, to illustrate this:

```java

public class City {

  private final String name;
  private final double inhabitants;
  private final String weather;

  public City() {
  } 

  // getters and toString  omitted for brevity

}

```

Now, the `City` class has a zero-argument constructor. If you want to initialize one, then you don't need to provide it with anything - you can just go ahead and do it. 

But this can cause us problems, too:

```java

City city = new City();
city.getName(); // throws a NullPointerException!

```

It's tempting to code around this with an `if` statement:

```java

City city = new City();

if (!null == city.getName()) {
  System.out.println("City name: "city.getName());
} else {
  System.out.println("City does not have a name")
}


```

Try and think, in a large and complex application, of all the possible points where a value might unexpectedly be `null`. Imagine all the different logical branches you'd have to write, the complexity of the tests, and the messiness of the codebase. It sounds awful, doesn't it?

Luckily, `Optional` is here to help us out.

## Optional - a box that is sometimes empty
A good, simple way to think about `Optional` is: **a box that has space for a value, that is sometimes empty and sometimes has a value in it.**

If we use an `Optional` rather than passing a value around directly, then we can avoid null pointers and gain a much more elegant way of controlling flow in case of a null value. 

Check out the example code - it contains a typical use case for `Optional`. Here, it turns out that Tokyo's inhabitants data is missing. Because we've used `Optional`, we can handle this in code; we supply a value in case the value is missing. This is one way to use `Optional`; alternatives include:

* writing a lambda to provide the missing value (e.g., we could make an HTTP client call to find out Tokyo's population)
* throwing an exception.

 
