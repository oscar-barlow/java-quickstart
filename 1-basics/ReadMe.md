# Java Basics

## Introduction
The goal of this section is to introduce you to some features of Java which, if you've only used Ruby or JavaScript before, you probably aren't familiar with, as neither of those languages contain them. 

In brief, these are:

* Compilation
* Static typing
* Java's data structures
* Interfaces
* Streams
* Throwing and catching exceptions

There's also a challenge for you to achieve by the end of the week, to help you consolidate your knowledge.

But first, let's talk about working with an IDE (IntelliJ).

### Working with an IDE

While it is *possible* to write Java using vim, or a text editor like Atom, it's not very much fun*.

Most Java developers use an IDE, an Integrated Development Environment. If you haven't already, I'd suggest getting a 3-month trial of IntelliJ through Tim Buchalka's udemy course, as linked in the intro.

In general, an IDE just makes it more convenient for you to write Java, by doing the following:

* making it easier to navigate around your code
* helping manage your dependencies
* maintaining a large library of plugins (check out [my favourite](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar))
* flagging errors or things that your code that could be improved
* Suggesting methods to you and showing you what parameters they take

I strongly suggest you download IntelliJ for your machine, and use it through the rest of this course. 

## Compilation

Java is a **compiled** language. When you're done working on your code, to actually get it to do anything, you need to run it through the Java Compiler. This produces **bytecode** - code in a format that is less easy for humans to read, but more easy for machines to understand. Any device that can run the version of Java you coded in, can run your bytecode.

The Java Virtual Machine is what runs your bytecode, either interpreting it or just-in-time compiling it to **machine code**.

If your code has errors in it that mean that it can't be compiled, IntelliJ will refuse to 

### Mini-Challenge
A lot of these Java-related terms are probably pretty unfamiliar to you! I suggest you stop here for a moment and take a moment to write one-sentence definitions of, at minimum, the:

* Java Development Kit (JDK)
* Java Compiler
* Java Virtual Machine
* Java Runtime Environment
* The 'heap'
* Garbage collection

## Static Typing
In Ruby and in Javascript, you can assign pretty much anything you want to a variable, and then reassign the value of the variable to something completely different. For example, the following is valid (if odd!) Javascript:

```javascript
var a = "a string";
var a = 1;
var a = true;
var a = { type: "string", value: "what I just wrote" }
```
This will not work in Java. When you define a variable in Java, you also define its **type** (a class or **primitive** name).

Imagine you're working on a project with a class called `Dog`. If you wanted to store a `Dog` object in a variable, you'd do something like the following:

```java
Dog fido = new Dog();
```

There, at the beginning of the line, you set the type of variable `fido` to `Dog`. You can assign any `Dog` object to fido, but it must be a `Dog`. If you tried to do something like the following:

```java
Dog fido = new Octopus();
```

Your code would not compile. It is possible to force one type of object to become another with **casting**, but it's generally not a very good  idea - if you want to know more about this, research casting a double to an integer.

Challenge: codewars

* If you want to know more about this, I'd suggest reading [TDD in Java with JUnit  Without Using an IDE](https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-ide-cd24d38adff).
