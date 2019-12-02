# Testing, Build Tools, and Exceptions

## Introduction
This goal of this section is for you to be able to test-drive the development of a simple object-oriented Java app. When you've gone through the following sections, complete the challenge at the bottom of this page to consolidate your knowledge.

## Sections

1. [Build Tools](2-1-buildtools-gradle-maven)
2. [Testing, Mocking, Stubbing, and Verifying](2-2-testing-stubbing-verifying)
3. [Debugging, and Handling Exceptions](2-3-debugging-handling-exceptions)

## Challenge: Airport
Write and thoroughly test a Java application that satisfies the following user
stories. Command-line applications in Java are actually quite involved, so
this challenge can be considered complete when you have a test suite that
covers the stories below (plus exceptions, etc).

### Bonus
Make a command-line interface for your Airport application.

```
As an air traffic controller
I want to instruct a plane to land at an airport
So I can get passengers to a destination

As an air traffic controller
I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport
So I can get passengers on the way to their destination

As an air traffic controller
I want to prevent takeoff when weather is stormy
To ensure safety

As an air traffic controller
I want to prevent landing when weather is stormy
To ensure safety

As an air traffic controller
I want to prevent landing when the airport is full
To ensure safety

As the system designer
I would like a default airport capacity that can be overridden as appropriate
So that the software can be used for many different airports
```

Many thanks to [Makers Academy](http://www.makersacademy.com/) for letting me
borrow one of their challenges!
