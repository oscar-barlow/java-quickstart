# 1.1 Compilation, Static Types, and Data Structures

In this section, I want to introduce you to some noteworthy features of Java that bear a little explanation:

* Compilation
* Static typing
* Java's data structures.

But first, let's talk about working with an Integrated Development Environment (IDE).

### Working with an IDE

While it is *possible* to write Java using vim, or a text editor like Atom, it's not very much fun(1).

Most Java developers use an IDE. An IDE makes it more convenient for you to write Java, by doing the following:

* making it easier to navigate around your code
* helping manage your dependencies
* maintaining a large library of plugins (check out [my favourite](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar))
* flagging errors or things that your code that could be improved
* Suggesting methods to you and showing you what parameters they take

I strongly suggest you download IntelliJ IDEA to your machine, and use it through the rest of this course.

This folder contains a bare-bones Java application for you to play around with as you progress through the material in this section. Alternatively...

### Mini-Challenge
Create a [Hello, World](https://www.jetbrains.com/help/idea/creating-running-and-packaging-your-first-java-application.html) application in Java.

## Compilation
Java is a **compiled** language. When you're done working on your code, to actually get it to do anything, you need to run it through the Java Compiler. This produces **bytecode** - code in a format that is less easy for humans to read, but more easy for machines to understand. Any device that can run the version of Java you coded in, can run your bytecode.

The Java Virtual Machine is what runs your bytecode, either interpreting it or just-in-time compiling it to **machine code**.

If your code has errors in it that mean that it can't be compiled, IntelliJ will refuse to compile it and highlight the problematic parts of your code to you.

### Mini-Challenge
A lot of these Java-related terms are probably pretty unfamiliar to you! I suggest you stop here for a moment and take a moment to write one-sentence definitions of, at minimum, the:

* Java Development Kit (JDK)
* Java Compiler
* Java Virtual Machine
* Java Runtime Environment
* The 'heap'
* Garbage collection

## Static Types
In Ruby and in Javascript, you can assign pretty much anything you want to a variable, and then reassign the value of the variable to something completely different. For example, the following is valid (if odd!) Javascript:

```javascript
var a = "a string";
a = 1;
a = true;
a = { type: "string", value: "what I just wrote" }
```
This will not work in Java. When you define a variable in Java, you also define its **type** (a class or **primitive** name).

Imagine you're working on a project with a class called `Dog`. If you wanted to store a `Dog` object in a variable, you'd do something like the following:

```java
Dog fido = new Dog();
```

There, at the beginning of the line, you set the type of variable `fido` to `Dog`. You can assign any `Dog` object to fido, but it must be a `Dog`. Additionally, Java requires you to define what type of object will be returned by a method, e.g.

```java
public class Dog {

  private String name;

  public String getName() {
    return this.name;
  }

}
```

And to define what kind of object you are giving to your methods, e.g.:

```java
public class Dog {

  private int age;

  public void setAge(int age) {
    this.age = age;
  }

}
```

However, if you tried to do something like the following:

```java
Dog fido = new Octopus();
```

Your code would not compile. It is possible to force one type of object to become another with **casting**, but it's probably not a very good idea - if you want to know more about this, research casting a double to an integer.

Additionally, arrays may only contain objects of one type. A `String[]` is an array that may only contain `String`s, a `Dog[]` may only contain `Dog`s, and so on.

### Mini-challenge
Why does anyone bother with static typing? Doesn't it just tie your hands?

Do some research and find out.

## Java's Data Structures

Java has data structures that neither Ruby nor Javascript have, like `Set`s. Addtionally, many of these classes are abstract and can't or shouldn't be instantiated directly.

The subclasses of these structures (e.g. `HashMap`, `TreeSet`, `RoleList`) are too numerous to be worth the time to describe here. In general, it is probably better to learn about them in context - in the course of your job, when you need to use them. For the moment, simply be aware that they exist, and they are meaningfully different from each other. In fact...

### Mini-challenge

Mostly, you'll learn about using Java's data structures in the course of your work. However, to give you a taste of how the subclasses can be different from each other - what is the difference between an `Array`, an `ArrayList` and a `LinkedList`? Why might you use each one?

---
1. If you want to know more about this, I'd suggest reading [TDD in Java with JUnit Without Using an IDE](https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-ide-cd24d38adff)
