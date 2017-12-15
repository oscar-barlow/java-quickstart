# 3.1 Lombok

## Introduction
The goal of this section is to reduce the amount of similar code you have to write, using a very popular Java library: [Lombok](https://projectlombok.org/). Compared to some of the other sections in this course, this section is quite short. Lombok is easy to learn, and very useful, especially when combined with the other frameworks which will be introduced in subsequent sections.  

Lombok enables you keep your classes free of 'boilerplate' code by getting rid of getters, setters, and constructors. Additionally, Lombok can implement the *Builder* pattern in your classes, which is a highly readable alternative to a constructor.

To work with Lombok in IntelliJ, you will need to install the Lombok plugin. Additionally, you will need enable annotation processing in your project settings.  

## Getters and Setters
Check out the `GreatDane` class in this project. It's a pretty long class, but it really do anything!

Compare it to the `Collie` class. It's still pretty long for an object that simple, but it's much smaller, because the getters aren't there. By annotating the class with `@Value`, we allow Lombok to supply them instead of writing them ourselves.

### Mini-challenge
Have a look at the `Greyhound` class. At the moment, it's over 60 lines long, most of which is taken up by getters and setters. There's a Lombok annotation that will allow you to get rid of both getters and setters. Find it, and refactor the `Greyhoud` class to use it. 

## Constructors and Builders
Open up the `Chihuahua class`. Because the `@AllArgsConstructor` Lombok annotation has been used, there's no need to write a constructor for this class. As a result, it's much smaller, and much more readable than any of the preceding classes.

The `@Builder` annotation has also been included on `Chihuahua`. This is an implementation of the [builder pattern](https://en.wikipedia.org/wiki/Builder_pattern) in Java. The value of this should become clear by looking at `LombokApplication`, where a `Collie` and a `Chihuahua` have been initialised. 

Initialising the `Chihuahua` takes up more space on the screen, but it's also much more readable, as you are able to see exactly which variables correspond to which field. This is especially useful when you encounter classes with a large number of dependencies.

