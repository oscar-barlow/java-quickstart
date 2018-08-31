# Controllers and Validation

The goal of this section is to enable you to control the quality of data that is passed from one part of your application to another. After completing this section, you should be able to write a Spring Boot web application with controller validation, as well as validation in other meaningful parts of the application.

## Controller Validation
In many web applications, the only way for data  to get into the application may be through POST-ing to a controller. 

This means that it's a good idea to ensure that the data that gets passed on to other areas of your application is valid - that it's not missing an required parts, for example. Otherwise you'll have to write a lot of branching logic, or optionals, to try and prevent errors from occurring.

Luckily, Spring makes this easy. Have a look at the `CreateTodoController` class, which contains a controller endpoint for creating todos. Although all the app in this section does is print out the new todo object to the console, in reality this is where the object would be passed to the application's service layer to have business logic applied to it.

Spring is able to deserialise the body of a POST request into a Java object, because the `@RequestBody` annotation has been added to the parameter of the controller's `createTodo` method. And because that same parameter has also been annotated with `@Valid` (and because [https://spring.io/blog/2009/11/17/spring-3-type-conversion-and-validation/](Hibernate is present on the classpath)), the `CreateTodo` object is validated to ensure it conforms to the requirements as specified in the annotations on its fields.

Any request to the `/create` endpoint that doesn't contain a valid `CreateTodo` object in its payload will fail. Therefore, you can be sure that any object passed through the rest of the application will contain the minimum data you need it to have.

Check out the `CreateTodoControllerTest` class to see this in action. You can also run the application locally, and try hitting it with curl or Postman to see it in action.

## Mini-challenge
A pretty good set of validation annotations are built into Java - you can see some in this project, and a more complete list is given under section 4. of [https://www.baeldung.com/javax-validation](this tutorial blog post).

Sometimes, however, there may be validations that are specific to your domain. For this mini-challenge, write a validation 'description' field of the `CreateTodo` class: it must be at least three words long. The DZone blog post [Create Your Own Constraints With Bean Validation 2.0](https://dzone.com/articles/create-your-own-constraint-with-bean-validation-20) contains instructions about how to do this (ignore the section about the POM file).

Write tests to ensure your validation works. 

