# 1.3.1 Streams

Here's something that's really easy to do in Ruby:

```ruby

numbers = [1, 2, 3, 4, 5];
doubled-numbers = numbers.map { |n| n * 2 }

```

There are various other operations and transformations - filtering, transforming from one class or data-type to another, or just simply iterating over an array or a hash - that are just as easy in Ruby  and comparitively easy in Javascript.

This kind of operation is a little more complicated in Java, but not much. The main thing you need to know is this: in order to map, filter, etc, you need to use an object called a `Stream`. What's a `Stream`?

Well, if you Google around a little bit, you'll probably see something along the lines of: *a `Stream` is a Monad, and an element of functional programming in Java.*

This is not that helpful as an introductory-level definition. So, for the moment, I'm going to propose a much simpler definition:

**a `Stream` is an object that allows you to apply collect, filtering, and other looping operations to a `Collection`.** 

I've provided some examples in the `StreamsExamples` application in this project. In order they are:

1. Summing an array of integers;
2. Simply looping over a collection;
3. Filtering values in a collection, and returning them as a list; and 
4. Transforming a collection of objects from one type to another.

I'll also discuss each one in turn.

## 1. Summing an array of integers
Let's start with a simple one. We've got an array of integers, and we want to know the total.

I've provided two ways of doing this, in `IntegerSummer` class in the `summing` package. The first method takes a simple `int[]`; the second takes a `List` of `Integers`. I've provided the second implementation because, as we saw in the first section, arrays in Java have shortcomings which can make them a bit of a pain to work with, and it's way more likely in the course of your work that you'll be working with `List`s.

This also gives me the opportunity to introduce a new Java concept, in the form of a mini-challenge!

### Mini-challenge
Firstly, you'll see that both methods in `IntegerSummer` have the same name: `sum()`. How does Java know which one to use?  Look up **method overloading**.

Secondly, this method uses two very similar data types: an `int` and an `Integer`. What is the diference between them? When would you use one or the other? How do you convert between them?  

## 2. Simply looping over a collection
Sometimes, we have a collection of objects, and we really only need to make sure that a particular method gets applied to each element of the collection. 

For example, let's say we want to send off some data to 3rd party, and we're not too worried about the result that comes back (so-called 'fire and forget').

In this case, we can `forEach()`. This is a `Stream` designed for exactly this kind of purpose. You'll see an example in `FireAndForgetter` in the `foreach` package.

Note the syntax:

```java
request -> requestSender.send(request)
```

This is a **lambda** - a concept you may remember from way back when you did codeacademy's lesson on [Blocs, Procs and Lambdas](https://www.codecademy.com/courses/learn-ruby/lessons/blocks-procs-and-lambdas/exercises/you-know-this) in Ruby!

If you're working with `Streams`, you're going to be working with lambdas (the example above). This means that you're going to be writing an 'anonymous' method like the one just above, or providing a reference to a method (e.g. `Integer::getValue` as in `IntegerSummer`), to apply to each item in a collection. 

Java has some restrictions about what you can do as part of a stream - for instance, you cannot modify the state of the course of the stream. You will come across others as you work with `Stream`s.     

Finally for this section, a warning. As a Java newbie, it can be extremely tempting to abuse `forEach()`. If you find yourself doing this kind of thing:

```java

List<TransformedObject> transformedList;

someList.forEach(item -> {
  TransformedObject transformed = objectTransformer.transform(item);
  transformedList.add(transformed);
})

```

This is a code smell. We'll learn the proper way of doing this in item (4).

## 3. Filtering values in a collection, and returning them as a list
Check out the `NameFilterer` in the `filtering` package. Hopefully, as you pick your way through this, you will start to become more familiar with stream and lambda syntax.

I've provided a couple of different filters examples - one with a couple of criteria strung together in the lambda, and another using a custom predicate (filter condition) which I've defined.

Also, do note that now it's not enough to simply apply the filters - we also have to tell the `Stream` what kind of object we expect when we're done. In this case, I'm using `Collectors.toList()` to get a `List` out of the stream. 

## 4. Transforming a collection of objects from one type to another
We've seen this already, a little bit, in the first example - where we `map`ped an `int` to an `Integer`. Usually, however, we'll want to do something a bit more sophisticated than that.

Let's imagine, for instance, that we want to take a list of city names, and add some information (like the current weather, and total population) before we return them. A `String` isn't up to the task of that, nor is a `HashMap`, so we're going to create a our own class called `City` which will contain it.

Check out the example in `CityTransformer`, in the `transforming` package. 

I'll admit, the example is a little bit contrived! And normally you wouldn't use `if`/`else` statements to fill in those values. Hopefully the example nonetheless serves the purpose of starting with one type of object, and ending up with another. 

I've chosen to implement Java's `Function` interface in my `CityTransformer`, which is why I don't need to tell the stream which method to call.

## Conclusion
It can take a while to get your head around Java streams - this style of coding (functional) is noticeably different to the object-oriented style you may be used to. But they are extremely important to master. I encourage you to play around with the examples I've provided to get a little more comfortable.      