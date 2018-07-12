# Spring Boot

## Introduction
Spring Boot is a convention-over-configuration style Java framework for rapid application development. By adding remarkably few annotations to a Java application, you enable it to accept and respond to web requests. The goal of this chapter is to show you how to build an web application using Spring Boot. 

Spring Boot is based on the Spring framework. The most important concept from Spring to understand, as you develop Spring Boot web applications, is called **Inversion of Control**.

If you're doing good Object-Oriented programming, you should delegate different areas of responsibility to different classes within your application. This makes your code much easier to understand, and test. However, now your main application class will contain classes that it depends on, each of which may contain classes that those classes depend on, which may each contain yet more classes that these classes depend on!

In this situation, you the programmer are not only responsible for delegating different areas of functionality to different classes - you are also responsible for initialising objects that each class depends upon, and then supplying it to that class as a constructor argument. 

This can lead to a really ugly mess. For example, let's suppose we're creating a `BikeShopApplication`, similar to what we have done in previous chapters but more advanced. Our `BikeShop` contains (depends upon) a `Warehouse` object. In terms of dependencies, this is not too bad right now, as you can see in the following pseudocode example: 

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
BikeShopApplication bikeShopApplication = new BikeShopApplication(new Warehouse(ImmutableList.of(new Locker(100, 50, 50), new Locker(75, 40, 40))));
 ```

This is starting to look a bit complicated.



* Introduction to the Spring framework
* Configuration, Profiles and Testing
* Controllers and Validation
