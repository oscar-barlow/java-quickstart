# Lombok, Jackson and Guava

## Introduction
The goal of this section is to show you some commonly-used libraries in Java development. By the end of this section, you should be able to consume and work with data from a public web API.

The libraries covered are:

1. [Lombok](3-1-lombok)
2. [Jackson & Guava](3-2-jackson-guava)

These libraries are all huge, and very mature. They also contain a lot of material - so this chapter isn't a conclusive guide to any of these libraries, by any means. Rather, the intent is to give you a flavour of what the libraries are about. Respectively:

* Lombok: avoid writing boilerplate code
* Jackson: convert data to different formats, into and out of code
* Guava: convenient utilities that seem like they should be built in to Java

## Challenge
Find out your GPS co-ordinates, then use the public [Teleport API](https://developers.teleport.org/api/) to find the nearest cities to that location.

Then use teleport to get basic information about each of the nearest cities - its population and any alternate names.

When you have a list of cities with information, write them out to a CSV. You will need to use Jackson's `CsvMapper` class to do this.

You can roll our own HTTP client, as in section 2 of this chapter, or feel free to use a library instead.
