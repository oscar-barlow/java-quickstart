# 3.2 Jackson and Guava

## Introduction
After completing this section, you should be able to make a request to a public API with Java, and work with the data that comes back.

You'll do this with two new libraries, [Jackson](https://github.com/FasterXML/jackson) and [Guava](https://github.com/google/guava), as well as Lombok (introduced in the previous section).

Jackson is very useful for automatic serialisation and deserialisation of data. Guava was largely built and is maintained by Google engineers, although it is open source. It contains a lot of convenient things in it that you might expect to be part of the standard Java library!

## Data Transfer Objects
The great benefit of using Lombok and Jackson together, is that it makes it easy to work with [data transfer objects](https://martinfowler.com/eaaCatalog/dataTransferObject.html).
 
 
