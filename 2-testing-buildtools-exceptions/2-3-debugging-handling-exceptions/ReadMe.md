# 2.3 Handling and Testing Exceptions

## Introduction
The goal of this section is for you to understand about different types of exceptions in Java, and how to handle this in your code. Additionally, you should be able to write test scenarios to ensure that your application behaves how you want when it encounters an exception, and that it only exposes the information you allow it to.

## Exceptions
Let's start by taking things back to basics.

Occasionally, your code behaves in ways that you didn't anticipate, or users supply input in a form or manner that you weren't expecting, and so your code throws an exception. This is in fact pretty close to the [definition of an Exception](https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html) as provided by Oracle. The Oracle docs also give us three [advantages](https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html) of using exceptions in our code. I'd like to focus on the latter two described in that link:

* Propagating Errors Up the Call Stack
* Grouping and Differentiating Error Types

The first point makes it much easier to locate a bug in your code - by providing relevant information (the problematic method, the class it's in, and where *that* class method was called from). The second allows you to start developing hypotheses about *why* the error was thrown, and therefore what you might do to fix it.

Taken together those two points show us that, although it's not a good thing that code has thrown an exception, exceptions are *very* useful for debugging.

### Debugging Using an IDE
This provides an excellent opportunity to introduce a couple of techniques for debugging using an IDE such as IntelliJ IDEA.

In Ruby and JavaScript, you're probably used to doing something like the following:

```ruby
def transmogrify(doohickey)
  part_transformed = de_tubularise(doohickey)
  p(part_transformed)
  complete_transmogrification(part_transformed)
end
```

In the (extremely contrived!) example above, I defined a method to `transmogrify` a `doohickey`, but the method isn't producing the results expected. So we print out the value of the `part_transformed` variable to check what it is, and can carry on the debugging journey from there.

Alternatively, you might do something like this:

```ruby
def transmogrify(doohickey)
  part_transformed = de_tubularise(doohickey)
  pry
  complete_transmogrification(part_transformed)
end
``` 

In this case, you use [pry](https://github.com/pry/pry) to pause the execution of your code. You can then check the value of any variables you have access to (i.e. see the program's **state**), and that the methods you're calling are doing what you expect (i.e. checking the program's **behaviour**).

In Java, you can debug using the former method by using `System.out.println(<whatever>)` to find out the state of part of the program, and then try and make inferences about buggy behaviour from that.

But you'll have to re-compile the code and boot up the JVM every time you run your application, and that slows your debugging down. So Java developers typically prefer the latter method, and use their IDE's built-in debugging features.  

Check out `ErrorProneApplication`. Running the application will produce an exception, making it 'blow up' and stop running (the last item in the stack trace should be an exit code, which provides some further information about the error).

Next time you run the application, place a breakpoint on line 11 of the application - where we're trying to get the weather in Paris - and run the application in debug mode. The application's execution will pause, and IntelliJ will show you information about the **state** of the application right there on the screen - in italic text right next to the relevant code. 

At this point you'll see some buttons in the debugger console, that give you several options for how to get information about the application's **behaviour**: 
* step over: instruction the application to keep executing, line by line
* step into: go down a level into your application - see the details of what code is being executed by the methods your application is calling
* resume execution - and maybe hit the next breakdpoint

By pressing `alt + f8` in debug mode you can also enter evaluation mode, where you can try out methods, pass in new variables, and see what happens.

When your code isn't behaving as expected, IntelliJ is able to give you rich debugging information that can take you to the root cause of the problem extremely quickly.

You're likely to need to use these capabilities in the end-of-chapter challenge, so try them out now.

## Two types of exception: Checked and Unchecked
Exceptions come in two flavours: checked and unchecked. The difference is described [here](http://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/).

Both types of exceptions should be *handled*. This means that you, the developer, must anticipate what parts of your code might throw exceptions and decide what to do if that happens. If you don't handle an exception, your application will grind to a halt! Notice that, because looking up the weather in Paris throws an exception, the lines after that aren't even executed. Comment out that line and execution will proceed. 

On the other hand, if you do handle the exception, your application will throw the exception and then continue executing, and you may be able to provide some useful information to the end-user about what went wrong.

### Mini-challenge
Why do `RuntimeException`s not need to be explicitly handled? 

### Checked exceptions
The presence of checked exceptions in Java is part of the benefit of the compiler. By checking if a given method is able to throw an exception and forcing you to handle it, the compiler adds a layer of reliability to your code.

Checked exceptions must either be handled with a `try...catch` statement, or the method must declare that it throws an exceptions like so:

```java
public void readFile() throws IOException {
  // do something here...
}
```

Have a look at the `FileReader` class. There are two methods in there, which demonstrate a different ways of handling an exception. Note that `ErrorProneApplication`'s `main` method also throws an exception. If you don't explicitly `try... catch` an exception in a method, every method 'above' the exception-throwing method must handle the exception also. Otherwise, it would be possible for an exception to occur, but for the cause of the exception to be at best unclear, and at worst unknowable!  

### Unchecked exceptions
The compiler doesn't know about these types of exceptions. A good example is the `ArrayIndexOutOfBoundsException`; there's no way of knowing, when you're compile your code, if you're going to try and index into an array that's not quite as big as you thought it was.

Unchecked exceptions should be handled the same way as checked exceptions: by `try...catch`-ing or by specifying the type of exception thrown in the method declaration.

### Mini-challenge
Like tabs versus spaces and emacs versus vim, checked versus unchecked expcetions is a controversial topic, fiercely debated within the Java world!

Do some research on this topic. What are the arguments on either side? What is your opinion? 

### Re-throwing exceptions
Part of the benefit of using a `try...catch` block is that it allows you to show a different kind of exception to the client than was originally thrown by the method call.

There are a couple of reasons you might like to do this. Firstly, it allows you to customise the error message; this means you can send something more descriptive back to the end user than a stack trace. 

However, there is another consideration. We've spent some time in this section considering how exceptions can be extremely useful for debugging, because they show you give rich information about your system. But this could also be considered a *security risk**. How much information about your system do you want to expose to the outside world? Rethrowing an exception allows you to control what you expose, even when things go wrong.  

### Exceptions and code cleanliness
If you read the article linked above with a description of the differences between checked and unchecked exceptions, you will have seen a quote about exceptions from the [Java docs](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html):

*"If a client can reasonably be expected to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception"*

Given that unchecked exceptions can't be detected by the compiler, and that pretty much any method *could* throw an exception, doesn't that mean your Java code should be littlered with `try... catch` blocks?

Part of the answer for this is provided by the answer to the mini-challenge about `RuntimeException`s above, so if you haven't done that already, it would be a good idea to go back and do it now.

However, part of the answer is more to do with code cleanliness. Code that is littered with `try...catch` blocks is as hard to read and to test as code that is littered with `if... else` blocks. 

If you find yourself `try...catch`-ing a lot, you probably need to ask some questions about the structure of your code, like: 

* Could I extract a class and simplify some logic? 
* Am I using the right data structures? 
* Am I passing too much data around? 
* Could I be making 3rd party calls more intelligently?

And so on.    

## Logging
To help with troubleshooting, analytics and alerting, it's helpful to have good logging in your application.  

In Java, this means installing and configuring a logging package - there's one in this project. Some logging has been included in the `DodgyDataStore` class; where else might it be useful?

## Testing Exceptions
It's important to test how the code should behave when things go wrong - how does the application behave, what information does it provide about the problems it's encountering?

Check out the tests for the `FileReader` class. There are two tests - one for the expected behaviour when everything's alright, and one for when things go wrong (the 'unhappy' path).

The 'unhappy' test is run with JUnit, but rather than using JUnit's assertions I've installed [AssertJ](http://joel-costigliola.github.io/assertj/), an assertions library. I've decided to use AssertJ's `assertThatThrownBy` assertion for my unhappy test. I've provided the test in this syntax because it's not very intuitive for a beginner, but it is quite clean.

JUnit does have assertions for testing exceptions, though. In fact...

### Mini-challenge
Refactor the `shouldThrowRuntimeExceptionGivenFileDoesNotExist` test method to use JUnit assertions instead. 
