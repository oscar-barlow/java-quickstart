# Java Basics

## Introduction
The goal of this section is to introduce you to some of Java's features, for you to use as a basis for further self-directed learning.

In brief, these are:
* Compilation
* Static typing
* Java's data structures
* Interfaces
* Streams
* Throwing and catching exceptions

There's also a challenge to help you consolidate your knowledge.

But first, let's talk about working with an Integrated Development Environment (IDE).

### Working with an IDE

While it is *possible* to write Java using vim, or a text editor like Atom, it's not very much fun*.

Most Java developers use an IDE. An IDE makes it more convenient for you to write Java, by doing the following:

* making it easier to navigate around your code
* helping manage your dependencies
* maintaining a large library of plugins (check out [my favourite](https://plugins.jetbrains.com/plugin/8575-nyan-progress-bar))
* flagging errors or things that your code that could be improved
* Suggesting methods to you and showing you what parameters they take

I strongly suggest you download IntelliJ IDEA to your machine, and use it through the rest of this course.

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

But if you tried to do something like the following:

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

## Interfaces

You are probably already familiar with the concept of polymorphism from Ruby and Javascript. Classes may inherit from a super-class in Java, just like in those languages. Where Java differs is in the ability to:

1. Make the super-class abstract, i.e. impossible to instantiate; and
2. With the use of interfaces.

Of those, (1) is hopefully pretty self-explanatory. (2) however requires a little more information to understand.

If you google something like "what is an interface java," sooner or later you will find an explanation along the lines of: _Interfaces in Java represent a 'contract' between different parts of your application_. Personally speaking, I did not find this terribly helpful, as a beginner - although I will say, it does eventually make sense!

Let's define an interface:

```java
public interface Mammal {

  String makeNoise();

}
```

And then slightly modify the `Dog` class we introduced earlier, so that it 'implements' the `Mamal` interface:

```java
public class Dog implements Mammal {

  @Override
  public String makeNoise() {
    return "Woof!";
  } 

}
``` 

You'll see that the `Mammal` interface contains a single method without implementation details, and the `Dog` class contains a method by the same name (annotated with `@Override`), this time with implementation details. On a very basic level, this is how interfaces work: you define methods in them, and any class that you want to implement the interface *must* define those methods. They can implement those methods in very different ways, however; in fact, as we'll see, this is rather the point.

 Let's define another class, `Cat`:

```java
public class Cat implements Mammal {

  @Override
  public String makeNoise() {
    return "Miaow!"
  }

}
```

What does this get us? Well, now that we have two classes that implement `Mammal`, we could so something like the following:

```java
  Dog fido = new Dog();
  Cat paws = new Cat();

  Mammal[] mammals = new Mammal[]{fido, paws};

  for (Mammal mammal : mammals) {
    mammal.makeNoise();
  }
```

The syntax may be a little unfamiliar - but hopefully you can see what the above loop does! The key is this: because both `Dog` and `Cat` implement the `Mammal` interface, **we can rely on both of them to have the same behaviour.**

OK, but why in the real world would we do this? Well, let's imagine we're working on a web application, and we want and as part of that we want to export some files. We'll do this with a class called `FileExporter`:

```java
public class FileExporter {

  private final FileExportOperation fileExportOperation;

  public void export() {
    fileExportOperation.export();
  }

}
```

In this case, the our `FileExporter` class contains an interface called `FileExportOperation`, which looks like this:

```java
public interface FileExportOperation {

  void export();

}
``` 


Let's define the class that will actually do the work of the exporting - that will implement the `FileExportOperation` interface:


```java
public class SftpFileExportService implements FileExportOperation {

  @Override
  public void export() {
    // do some things that export a file to SFTP here
  }

}
```

All well and good, right? Well what if we need to make a change? Specifically in this case, what if we want to export to something like Amazon S3 rather than SFTP?

We can do that pretty simply:

```java
public class S3FileExportService implements FileExportOperation {

  @Override
  public void export() {
    // do some things that export a file to S3 here
  }

}
```

Here's the important thing: we might need to change a bit of configuration, but **we don't need to change the `FileExporter` class.** As long as it has something that implements the `FileExportOperation` class inside it, it's happy. 

This is what people mean by contracts - classes that can be relied upon to implement a certain behaviour, allowing you to make changes in your application without worrying that something will break.

Todo:
1. break out into seprate packages
2. other items in the table of contents

Challenge: codewars

* If you want to know more about this, I'd suggest reading [TDD in Java with JUnit Without Using an IDE](https://medium.com/@pelensky/java-tdd-with-junit-without-using-an-ide-cd24d38adff)
