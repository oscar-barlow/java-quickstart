# 3.1 Lombok

## Introduction
The goal of this section is to reduce the amount of similar code you have to write, using a very popular Java library: [Lombok](https://projectlombok.org/). Compared to some of the other sections in this course, this section is quite short. Lombok is easy to learn, and very useful, especially when combined with the other frameworks which will be introduced in chapter 3.  

Lombok enables you keep your classes free of [boilerplate](https://en.wikipedia.org/wiki/Boilerplate_code) code by getting rid of getters, setters, and constructors. Additionally, Lombok can implement the *Builder* pattern in your classes, which is a highly readable alternative to a constructor.

To work with Lombok in IntelliJ, you will need to install the Lombok plugin. Additionally, you will need enable annotation processing in your project settings.  

## Getters and Setters
Check out the `GreatDane` class in this project. It's a pretty long class, but it doesn't really do anything!

Compare it to the `Collie` class, which is still pretty long for an object that simple, but it's much smaller, because the getters aren't there. By annotating the class' fields with `@Getter`, we allow Lombok to supply them instead of writing them ourselves. 

You can get IntelliJ to show you what code Lombok is writing on your behalf: right click on any class with Lombok annotations in it and select Refactor > Delombok > All lombok annotations. 

### Mini-challenge
Have a look at the `Greyhound` class. At the moment, it's over 60 lines long, most of which is taken up by getters and setters. There are several ways you can use Lombok annotations to  avoid having to write both getters and setters. Find a way, and refactor the `Greyhoud` class to use it. 

## Constructors and Builders
Open up the `Chihuahua class`. Because the `@Value` Lombok annotation has been used, there's no need to annotate any of the fields with `@Getter` or write a constructor for this class. As a result, it's much smaller, and much more readable than any of the preceding classes.

The `@Builder` annotation has also been included on `Chihuahua`. This is an implementation of the [builder pattern](https://en.wikipedia.org/wiki/Builder_pattern) in Java. The value of this should become clear by looking at `LombokApplication`, where a `Collie` and a `Chihuahua` have been initialised. 

Initialising the `Chihuahua` with a builder takes up more space on the screen, but it's also much more readable, as you are able to see exactly which variables correspond to which field. This is especially useful when you encounter classes with a large number of dependencies - you don't have to remember the order of arguments, as instead you can use [fluent](https://en.wikipedia.org/wiki/Fluent_interface) methods to set the value of fields on initialisation. Use IntelliJ's Delombok functionality to see how it works. 

### Mini-challenge
Refactor the challenge at the end of chapter 2 (Airport) to use Lombok. Remove as much boilerplate as you can.

