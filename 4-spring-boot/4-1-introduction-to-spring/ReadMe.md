# Introduction to Spring

## Introduction
The goal of this section is to enable you to independently start a Spring Boot web application project. 

After completing this section, you should understand how Spring creates and wires together the objects that constitute your application, and therefore be able to write your own classes and use them in a new application.

It is recommended that you complete the mini-challenge at the end of this section to consolidate your knowledge.

## Spring Initializr
The recommended way to start a Spring Boot project is with the [Spring Initializr](https://start.spring.io/). As you check out the application in this section you will see that Spring's annotations are fairly minimal and non-invasive, and it might be possible to just add them to an existing project, but this process would likely to be quite slow and frustrating. IntelliJ IDEA also has support for Spring Initializr, and you may prefer to use this, though experience suggests the web version is more reliable. 

## Spring Boot Applications
Let's take a look at the code in this section. In previous code samples, various classes are instantiated, combined, and then their methods are invoked to produce some behaviour. Something different is going on here, however. First of all, the class containing the application's `main` is method is annotated with `@SpringBootApplication`. Additionally, the static method `run` from the `SpringApplication` class is called in the body of the application's `main` method - the method. Let's look at each of these in turn.

### @SpringBootApplication
`@SpringBootApplication` is syntactic sugar for the following three annotations:

* `@Configuration`
* `@ComponentScan`
* `@EnableAutoConfiguration`

#### @Configuration
This annotation allows you to specify details about your Spring Boot application in Java code rather than in external XML files. Typically, this is done through annotations on classes and methods. This means, you can do it while you're developing your classes and methods, rather than having to track it as a separate task.

Additionally, this annotation allows this class to add Spring beans to the application context, or to import other configuration classes.   

#### @ComponentScan
This annotation instructs Spring to scan through the package in which the class with this annotation sits, and register all of the Spring beans it finds in the application context.

#### @EnableAutoConfiguration
This annotation instructs Spring to automatically make certain configuration choices, based on the `jar`s it finds on the classpath. For example, this application uses [Thymeleaf](https://www.thymeleaf.org/) as a template engine. Spring Boot detects this and 'automagically' configures its use. 

### SpringBootApplication.run
This is a method that attempts to create an application context on your behalf. An application context contains a bean factory, that is, a class whose job it is to instantiate the beans used by your application. In addition, the context provides a convenient way to load files (e.g. images, yaml files) in your project.

So, when you run the `main` method of the Spring Boot application in this project, this is what's happening:

1. Spring attempts to decide what type of application context to create on your behalf, using [this algorithm](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html#boot-features-web-environment).
2. Because it is annotated with `@Configuration`, the `RandomDogImageApplication` class is given the authority to add Spring beans to the application context.
3. Because it is annotated with `@ComponentScan`, Spring scans through the `com.javaquickstart.introductiontospring` package looking for classes that are annotated with Spring annotations, and adds them to the context
4. Because it is annotated with `@EnableAutoConfiguration`, Spring makes assumptions about your application. In this case, as Thymeleaf is installed as a dependency, Spring assumes it should be used as a template engine. 
5. The application context uses its bean factory to instantiate the classes required by your application, including providing dependencies to classes that need them.

Check out the `ApplicationContextTest`. The `@Autowired` annotation has been used to gain access to the application context. Use IntelliJ's debugger feature to check it out - see what dependencies it has, what methods it has, and dig into the bean creation factory to see where all the Spring beans for this project are registered. 

### Spring Beans vs Java Beans
The term 'Spring bean' has been used a lot in this readme! It's important to understand that a Spring bean is different to a Java bean.

A Java bean is a term for a type of object conventionally used in Java programming. Its properties are described in [this StackOverflow answer](https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly#3295517).

On the other hand, a Spring bean is *a class that is known to the Spring application context*. You make classes known to the Spring application context by adding annotations to them, including:

* `@Service`
* `@Controller`
* `@Component`

Amongst others.

### Mini-challenge
Look through the application in the `com.javaquickstart.introductiontospring` package. Given the concepts explained above, can you understand how the application fits together?
 
If so, create a new Spring Boot web application project that takes a user's first name and last name, then greets them with the current date and time. When using the Initializr, make sure to click to display the full version of the Initializr - you will see the huge amount of libraries available to you to bootstrap various different types of application. At minimum you'll need the Web dependencies, and if you want your application to be able to display an HTML page, you will want a template framework like Thymeleaf. The Lombok dependency may be helpful also.

The [Spring Guides](https://spring.io/guides) may be useful if you get stuck. 
