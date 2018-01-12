# 3.2 Jackson and Guava

## Introduction
After completing this section, you should be able to make a request to a public API with Java, and work with the data that comes back.

You'll do this with two new libraries, [Jackson](https://github.com/FasterXML/jackson) and [Guava](https://github.com/google/guava), as well as Lombok (introduced in the previous section).

Jackson is very useful for automatic serialisation and de-serialisation of data. Guava was largely built and is maintained by Google engineers, although it is open source. Over its history, various bits of Guava have become so widely used that they eventually got absorbed into the Java standard library!

## Data Transfer Objects
The great benefit of using Lombok and Jackson together is that it makes it easy to work with [data transfer objects](https://martinfowler.com/eaaCatalog/dataTransferObject.html).
 
Check out the DogApplication

Why is it good to use a data transfer object?
* keep your method parameters tidy
* prevent excess network calls
* while you're writing java, you're only writing java. you don't have to piss around with JSON.

Why is Guava good?
* if you have an intuition that something in Java should just be a bit easier than it seems, then go look at Guava. 
 
