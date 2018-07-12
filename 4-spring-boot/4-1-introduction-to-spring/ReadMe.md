# Introduction to Spring

## Introduction
The goal of this section is to enable you to independently start a Spring Boot web application project. 

After completing this section, you should understand how Spring creates and wires together the objects that constitute your application, and therefore be able to write your own classes and use them in a new application.

It is recommended that you complete the mini-challenge at the end of this section to consolidate your knowledge.

## Spring Initializr
The recommended way to start a Spring Boot project is with the [Spring Initializr](https://start.spring.io/). As you check out the application in this section you will see that Spring's annotations are fairly minimal and non-invasive, and it might theoretically be possible to just add them to an existing project, but this process would likely to be quite slow and frustrating. IntellIJ IDEA also has support for Spring Initializr, and you may prefer to use this, though experience suggests the web version is more reliable. 

## Spring Boot Applications
Let's take a look at the code in this section. In previous code samples, various classes are instantiated, combined, and then their methods are invoked to produce some behaviour. Something different is going on here, however. First of all, the class containing the application's `main` is method is annotated with `@SpringBootApplication`. Additionally, the static method `run` from the `SpringApplication` class is called in the body of the application's `main` method - the method. Let's look at each of these in turn.

### @SpringBootApplication
What is this


### SpringBootApplication.run
What is this

## Spring Beans and Reflection 
How does it work
annotations

Controller + params
Model


### Mini-challenge
Create a new Spring Boot web application project that takes a user's first name and last name, then greets them with the current date and time. When using the Initializr, make sure to click to display the full version of the Initializr - you will see the huge amount of libraries available to you to bootstrap various different types of application.

At minimum you'll need the Web dependencies, and if you want your application to be able to display an HTML page, you will want a template framework like Thymeleaf. The Lombok dependency may be helpful also. 
