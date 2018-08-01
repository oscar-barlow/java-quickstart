# Configuration, Profiles, and Testing
 
## Introduction
The goal of this section is to enable you to test a Spring Boot web application. You should already be familiar with how to write unit tests in Java from chapter two. Therefore, this section focuses more on integration and controller tests. After completing this section, you should be able to write well-tested Spring Boot web application.

In this section, we will also introduce the concepts of configuration classes, and of profiles.

## Configuration
We have already encountered the `@Configuration` annotation in the [previous section](./4-1-introduction-to-spring), in the breakdown of how a Spring application runs. To recap, the `@Configuration` annotation allows a class to add Spring beans to a Spring application context.

It's obviously important for the main application class to be able to do this. But sometimes other classes need to be able to do this too. Typical reasons for this include:

1. The bean isn't straightforward to initialise;
2. Customising beans;
2. You want to mock the bean for test purposes.

In these cases, you should write a configuration **class**. That is, a class that is annotated with `@Configuration`, and which provides beans to the application

### Beans that Aren't Straightforward to Initialise
Some objects cannot simply be initialised by using their constructors. As an example, check out the documentation for the [AWS (Amazon) S3 client](https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/s3/AmazonS3Client.html). All of the constructor methods are marked as deprecated - you should not rely on them. The documentation instead asks you to one of several static methods (e.g. `default()`) or to use a builder method.

If you needed to use an Amazon S3 client, you would add it as a dependency the regular way - by adding it as a field and constructor parameter in the class that's would use it. Then you would add a configuration class looking something like this:

```java
@Configuration
public class S3Configuration {

  @Bean
  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder.standard()
      .withRegion("eu-west-1")
      .build();
  }

}
```
The `S3Configuration` class is annotated with `@Configuration`, so Spring allows it to add beans beans to the application context. The method annotated with `@Bean` supplies a bean of type `AmazonS3` to the context, so it can be injected into classes that depend on it. 

Amazon S3 clients objects are not trivial to initialise, and usually require even more set up than you can see above to get them to work properly. For this reason, you cannot simply initialise them with a constructor. If this configuration class did not exist, Spring would not be able to produce a working Amazon S3 client, and the application using it would not work.

### Customising Beans
This is very similar to non-straightforward beans as described above, except that using a configuration class isn't mandatory - you only do it to customise an object how you like.

For example, the `ObjectMapper` class described in chapter 3, can be straightforwardly initialised with new:

```java
ObjectMapper objectMapper = new ObjectMapper
```

But by default, `ObjectMapper` serialises timestamps in a pretty unhelpful way:

example goes here
remedy goes here

### Mocking a Bean
Think about AWS s3 client
Don't want a real one in test
Use a configuration to create a fake one, using Mockito
example


## Profiles
Allow us to specify when we want to use which configuration
Very useful for testing

## Spring Boot Testing
Bring up spring context
Controller testing
Show the code
Need to bring something in from yaml

### Mini-challenge

