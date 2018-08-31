package com.javaquickstart.introductiontospring;

import org.springframework.stereotype.Service;

@Service
public class RandomDogImageService implements RandomDogImageOperation {

  private final DogApiClient dogApiClient;

  public RandomDogImageService(DogApiClient dogApiClient) {
    this.dogApiClient = dogApiClient;
  }

  @Override
  public String getRandomDogImageUrl() {
    final DogImageUrl randomDogImage = dogApiClient.getRandomDogImage();
    return randomDogImage.getImageUrl();
  }
}
