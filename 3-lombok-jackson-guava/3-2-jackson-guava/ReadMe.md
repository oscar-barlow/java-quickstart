# 3.2 Jackson and Guava

## Introduction
After completing this section, you should be able to make a request to a public API with Java, and work with the data that comes back.

You'll do this with two new libraries, [Jackson](https://github.com/FasterXML/jackson) and [Guava](https://github.com/google/guava), as well as Lombok (introduced in the previous section).

Jackson is very useful for automatic serialisation and de-serialisation of data. Guava was largely built and is maintained by Google engineers, although it is open source. Over its history, various bits of Guava have become so widely used that they eventually got absorbed into the Java standard library!

## Data Transfer Objects
The great benefit of using Lombok and Jackson together is that it makes it easy to work with [data transfer objects](https://martinfowler.com/eaaCatalog/dataTransferObject.html).
 
Run the `TriviaApplication` in the `com.javaquickstart.jacksonguava`. As long as you have a web connection, the application will print out some trivia questions that it's got from a web-based open trivia API.

If you make a request to the web trivia api (try using the same request as is in the code: `https://opentdb.com/api.php?amount=5` to get some randomly selected questions) in your browser, you'll see that it returns some JSON - something like this:

```json
{
  "response_code": 0,
  "results": [
    {
      "category": "Entertainment: Musicals & Theatres",
      "type": "multiple",
      "difficulty": "medium",
      "question": "Which of the following is not a piece from the 1950&#039;s musical West Side Story?",
      "correct_answer": "The Back Alley",
      "incorrect_answers": [
        "Maria",
        "Tonight",
        "Mambo"
      ]
    },
    (more...)
  ]
}
```  

And yet, when we log out the questions, we don't have to do any kind of JSON parsing or anything. We can in fact just call a getter for a field on the `Question` class.

This is because Jackson has parsed the JSON into a `Questions` object, and then further into individual `Question` objects. Importantly, the Java objects have exactly the same structure, and exactly the same field names as the JSON. Otherwise Jackson wouldn't know how to do the deserialisation. 

Jackson is a very mature Java library, the purpose of which is to make it trivial to work with data in other formats (XML, CSV, JSON) in code. A lot of what Jackson does is done by the `ObjectMapper` class. You can see it at work in the `TriviaService` class in this project.

When we use Jackson, very often we're using it to create data transfer objects. A typical use case for this type of object is to pass data around your application, which you can then easily access via getters. Using Jackson also means that, when you're coding with Java, you're **only** using Java. You don't have to context switch back and forth between Java and JSON/XML/CSV or however else your data might be coming in.      

## Convenience with Guava
Have a look at the `ParameterStringBuilder` class in this project, and the test class `TriviaServiceTest`. In the imports at the top of the class you'll see imports from `com.google.common`. In `ParameterStringBuilder` it's used to insert a character when joining two strings, and in the test code it's used to easily instantiate a `List`.    

If you think these seem like quite simple operations, then I invite you to check out how they would be done without Guava! Unfortunately, it's rather messy. Whenever you find this kind of thing in Java - something that's complex but which seems like it should be simple - it's worth checking to see if this problem has already been solved in Guava.

## Mini-challenge
Use Jackson to write the results of a call to the trivia API to a CSV file.   
 
