# 2.3 Handling and Testing Exceptions

## Introduction
The goal of this section is for you to understand about different types of exceptions in Java, and how to handle this in your code. Additionally, you should be able to write test scenarios to ensure that the right types of exceptions are being thrown.

## Exceptions
Let's start by taking things back to basics.

Occasionally, your code behaves in ways that you didn't anticipate, or users supply input in a form or manner that you weren't expecting, and so your code throws an exception. This is in fact pretty close to the [definition of an Exception](https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html) as provided by Oracle. The Oracle docs also give us three [advantages](https://docs.oracle.com/javase/tutorial/essential/exceptions/advantages.html) of using exceptions in our code. I'd like to focus on the latter two described in that link:

* Propagating Errors Up the Call Stack
* Grouping and Differentiating Error Types

The first point makes it much easier to locate a bug in your code - by providing relevant information (the problematic method, the class it's in, and where *that* class method was called from). The second allows you to start developing hypotheses about *why* the error was thrown, and therefore what you might do to fix it.

Taken together, those two points show us that although it's not a good thing that code has thrown an exception, exceptions are *very* useful for debugging.

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

In this case, you use pry to pause the execution of your code. You can then check the value of any variables you have access to (i.e. check the program's **state**), and that the methods you're calling are doing what you expect (i.e. checking the program's **behaviour**).

In Java, you can debug using the first method by using `System.out.println(<whatever>)` to find out the state of part of the program, and then try and make inferences about buggy behaviour from that.

But you'll have to re-compile the code and boot up the JVM every time you run your application, and that slows your debugging down. So Java developers typically prefer the second method, and use their IDE's built-in debugging features.  

Check out the code sample in this section, the `something something` application. Running the application will produce an exception, making it 'blow up' and stop running (the last item in the stack trace should be an exit code, which provides some further information about the error).

breakpoints
step over
step into
evaluate

## Handling Exceptions
try/catch
checked v unchecked, usually a matter of preference in your company. something about which opinions differ sharply.

## Logging
install logback
useful for debugging, monitoring, alerting

## Testing
testing with a JUnit rule
testing with AssertJ
