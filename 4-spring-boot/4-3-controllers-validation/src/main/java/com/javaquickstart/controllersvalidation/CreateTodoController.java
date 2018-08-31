package com.javaquickstart.controllersvalidation;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreateTodoController {

  @PostMapping("create")
  public void createTodo(@Valid @RequestBody CreateTodo createTodo) {
    System.out.println(createTodo);
  }

}
