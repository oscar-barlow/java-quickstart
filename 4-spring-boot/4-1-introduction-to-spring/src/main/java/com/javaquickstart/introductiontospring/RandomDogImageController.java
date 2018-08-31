package com.javaquickstart.introductiontospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomDogImageController {

  private final RandomDogImageOperation randomDogImageOperation;

  public RandomDogImageController(
      RandomDogImageOperation randomDogImageOperation) {
    this.randomDogImageOperation = randomDogImageOperation;
  }

  @GetMapping("/")
  public String root() {
    return "index";
  }

  @GetMapping("/image")
  public String showRandomDogImage(Model model) {
    final String imageUrl = randomDogImageOperation.getRandomDogImageUrl();
    model.addAttribute("imageUrl", imageUrl);
    return "image";
  }

  // todo - add route for showing a page with html button for getting random dog imnage
  // todo - add route for showing a page with random dog image
}
