package com.javaquickstart.lombok;

public class LombokApplication {

  public static void main(String[] args) {
    Collie collie = new Collie("Lassie", "Woof!", "Carraclough family", 3, 1f, 20f);
    System.out.println(collie.getName());

    Chihuahua chihuahua = Chihuahua.builder()
        .name("Chloe")
        .noise("Yip!")
        .ownerName("Vivian Ashe")
        .age(3)
        .height(0.2f)
        .weight(5f)
        .build();

    System.out.println(chihuahua.getName());
  }

}
