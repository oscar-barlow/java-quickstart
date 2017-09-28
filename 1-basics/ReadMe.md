# Java Basics

## Introduction
The goal of this section is to introduce you to some of Java's features, for you to use as a basis for further self-directed learning.

In brief, these are:

1. Compilation, static typing, and data structures
2. Interfaces
3. Streams
4. Throwing and catching exceptions

There's also a challenge to help you consolidate your knowledge.

## Interfaces

If you Google something like "what is an interface java," sooner or later you will find an explanation along the lines of: _Interfaces in Java represent a 'contract' between different parts of your application_. Personally speaking, I did not find this terribly helpful, as a beginner - although it does eventually make sense!

Let's define an interface:

```java
public interface Mammal {

  String makeNoise();

}
```

And then slightly modify the `Dog` class we introduced earlier, so that it 'implements' the `Mammal` interface:

```java
public class Dog implements Mammal {

  @Override
  public String makeNoise() {
    return "Woof!";
  }

}
```

You'll see that the `Mammal` interface contains a single method without implementation details, and the `Dog` class contains a method by the same name (annotated with `@Override`), this time with implementation details. On a very basic level, this is how interfaces work: you define methods in them, and any class that you want to implement the interface *must* define those methods. They can implement those methods in very different ways, however; in fact, as we'll see, this is part of the point.

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

OK, but why in the real world would we do this? Well, let's imagine we're working on a web application, and as part of that we want to export some files. We'll do this with a class called `FileExporter`:

```java
public class FileExporter {

  private final FileExportOperation fileExportOperation;

  public void export() {
    fileExportOperation.export();
  }

}
```

In this case, the our `FileExporter` class contains an interface called `FileExportOperation`. In the real world we would configure our application to automatically inject a class which implements `FileExportOperation` into the `FileExporter`. We'll cover this in a later chapter - in the meantime, let's look at the interface:

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

All well and good, right? Well what if we need to make a change? Specifically in this case, what if we want to export to Amazon S3 rather than SFTP?

We can do that pretty easily:

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

Challenge: codewars
