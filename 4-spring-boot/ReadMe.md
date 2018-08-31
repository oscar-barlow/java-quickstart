# Spring Boot

## Introduction
Spring Boot is a convention-over-configuration style Java framework for rapid application development. By adding remarkably few annotations to a Java application, you enable it to accept and respond to web requests. The goal of this chapter is to show you how to build an web application using Spring Boot. 

Spring Boot is based on the Spring framework. The most important concept from Spring to understand, as you develop Spring Boot web applications, is called **Inversion of Control**.

If you're doing good Object-Oriented programming, you should delegate different areas of responsibility to different classes within your application. This makes your code much easier to understand, and test. However, now your main application class will contain classes that it depends on, each of which may contain classes that those classes depend on, which may each contain yet more classes that these classes depend on!

In this situation, you the programmer are not only responsible for delegating different areas of functionality to different classes - you are also responsible for initialising objects that each class depends upon, and then supplying it to that class as a constructor argument. 

This can lead to really unreadable, fragile code. For example, let's suppose we're creating a `BikeShopApplication`, similar to what we have done in previous chapters but more advanced. Our `BikeShop` contains (depends upon) a `Warehouse` object. In terms of dependencies, this is not too bad right now, as you can see in the following pseudocode example: 

```java
BikeShopApplication bikeShopApplication = new BikeShopApplication(new Warehouse()); 
```

But our `Warehouse` depends on several `Locker` objects - actually, it takes an array of them. And each `Locker` is initialised three integers, which describe its height, width and depth in centimetres:

```java
List<Locker> lockers = ImmutableList.of(new Locker(100, 50, 50), new Locker(75, 30, 40);
Warehouse warehouse = new Warehouse(lockers);
```
So just to review, if we want to initialise a `BikeShopApplication`, this is what we have to do:

```java
BikeShopApplication bikeShopApplication = new BikeShopApplication(new Warehouse(ImmutableList.of(new Locker(100, 50, 50), new Locker(75, 30, 40))));
 ```
This is starting to look a bit complicated. Let's make it even more so, and imagine that each `Locker` takes a `Lock` object.

```java
BikeShopApplication bikeShopApplication = new BikeShopApplication(new Warehouse(ImmutableList.of(new Locker(100, 50, 50, new Lock()), new Locker(75, 30, 40, new Lock()))));
 ```

There are a couple of really big problems here. Firstly and more superficially, the constructor argument for the `BikeShopApplication` is getting unwieldy - it's getting hard to see where one argument ends and another begins. And this is only with one dependency in the `BikeShopApplication` - it would get even worse as we added more. It would be possible to manage some of this with Lombok (using a builder, for example, to initialise the application), but that is only part of the problem. The other problem is that, in this scenario, *when we modify a class that other classes depend on, we have to modify pretty much every other class in our application*. This would start to get annoying pretty quickly in the contrived example above. It's completely unsustainable in a real project with multiple developers working on the codebase.   

These two problems are what is meant by unreadable and fragile code.

Spring solves these problems by taking control of the process of initialising and supplying class dependencies throughout your application. When writing an application with Spring, we simply declare what dependencies a class has (as fields, and constructor arguments). Most of the time, we can then allow Spring to do the rest; sometimes we may need to provide additional instructions, in the form of configuration. 

## Additional Resources
Because Spring and Spring Boot are large, mature projects, you may benefit from using some supplementary resources to help you complete this section.

At minimum, it is recommended that you read up to the end of section 7.2 of the Spring documentation about the [IoC (Inversion of Control) container](https://docs.spring.io/spring-framework/docs/4.3.9.RELEASE/spring-framework-reference/html/beans.html). Feel free to read further. However, ignore everything to do with XML; this course will use Java-based configuration (annotations) instead of XML.

If you prefer to learn through video courses, [Dan Vega's Spring Boot udemy course](https://www.udemy.com/spring-boot-intro/learn/v4/overview) is recommended.

Finally, the [Spring Guides](https://spring.io/guides), maintained by the Spring team, are a very useful resource.

## Sections
1. [./4-1-introduction-to-spring]Introduction to the Spring framework
2. [./4-2-configuration-profiles-testing]Configuration, Profiles and Testing
3. [./4-3-controllers-validation]Controllers and Validation

# Challenge: Food Standards API
Using the [FSA food hygiene rating data API](http://ratings.food.gov.uk/open-data/en-GB), use Spring to produce a web application that implements the following user story:

```
As a user I want to see how food hygiene ratings are distributed by percentage across a selected Local Authority so that I can understand the profile of establishments in that authority.
```
