# 2.1 Build Tools: Maven and Gradle

## Introduction

As a bootcamp grad, you're most likely familiar with a couple of tools to help you manage your project dependencies: at minimum bundler and npm, and possibly also yarn.

Bundler allows you to install dependencies. You can manage your dependencies with npm and yarn, but additionaly they allow you to define **custom tasks** for your project. For example, when you're done working on a feature, you might run a command like `npm build` to run all your tests and then produce a minified version of your project in a `build` directory.

[Maven](https://maven.apache.org/) and [Gradle](https://gradle.org/) are similar to npm and yarn in that respect - they allow you to install and manage dependencies, and to define and execute custom tasks. As such, they are described as build tools rather than package managers.

## Using Gradle
This course focuses on Gradle in preference to Maven. There are a couple of reasons for this: firstly, Gradle is a little bit smarter in how it manages dependencies, and how it builds your project. Secondly and more importantly though, Gradle uses a Groovy-based DSL; whereas Maven uses XML, and it's *horrible*.

As a general rule in fact, if you're dealing with XML, you're probably dealing with a rather old plugin or library. XML has rather fallen out of favour in the Java community.     

### Installing Libraries
Let's clear up a potential confusion right away.

Even though Maven and Gradle are different build tools, they usually use the same repository of libraries. So when you want to add a library to your project, whether using either Maven or Gradle, you'll probably be navigating to [MVN Repository](https://mvnrepository.com/) (aka, Maven Repository). The difference is that for Maven, you'd add something like the following to your project's `pom.xml` file:

```xml
<dependency>
    <groupId>com.someOrganisation</groupId>
    <artifactId>a-library</artifactId>
    <version>2.44</version>
</dependency>

```  
See what I mean? *Gross*. 

On the other hand, with Gradle you'd add something like the following to your project's `build.gradle`:

```groovy
compile group: 'com.someOrganisation', name: 'a-library', version: '2.44'

``` 

### The Gradle Wrapper
Check out [this blog post](https://medium.com/@bherbst/understanding-the-gradle-wrapper-a62f35662ab7) by Bryan Herbst to understand what the Gradle wrapper is, and why you should use it.


### Mini-challenge
Install the [time4j calendar](https://mvnrepository.com/artifact/net.time4j/time4j-calendar) library and build a class that converts today's date into the French Revolutionary calendar format. You will probably need to use the `axis()` method.

You may need to refresh the Gradle project if you have not enabled auto-import. If you want to poke around the time4j calendar package to see how its classes work, expand the 'External Libraries' section in IntelliJ.

Vive la révolution!