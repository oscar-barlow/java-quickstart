# Testing, Build Tools, and Exceptions

## Introduction
This goal of this section is for you to be able to test-drive the development of a simple object-oriented Java app.

This chapter has the following sections:

1. [Build Tools](2-1-buildtools-gradle-maven)
2. [Testing, Mocking, Stubbing, and Spying](2-2-testing-stubbing-spying)
3. [Debugging, and Handling Exceptions](2-3-debugging-handling-exceptions)

## Challengei: Airport
Write and thoroughly test a Java application that satisfies the following user
stories. Command-line applications in Java are actually quite involved, so
this challenge can be considered complete when you have a test suite that
covers the stories below (plus exceptions, etc).

**Bonus**

Make a command-line interface for your Airport application.

```
As an air traffic controller
So I can get passengers to a destination
I want to instruct a plane to land at an airport

As an air traffic controller
So I can get passengers on the way to their destination
I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport

As an air traffic controller
To ensure safety
I want to prevent takeoff when weather is stormy

As an air traffic controller
To ensure safety
I want to prevent landing when weather is stormy

As an air traffic controller
To ensure safety
I want to prevent landing when the airport is full

As the system designer
So that the software can be used for many different airports
I would like a default airport capacity that can be overridden as appropriate
```

Many thanks to [Makers Academy](http://www.makersacademy.com/) for letting me
borrow one of their challenges!
