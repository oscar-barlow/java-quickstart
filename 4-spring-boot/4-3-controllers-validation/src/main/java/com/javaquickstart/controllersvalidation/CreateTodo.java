package com.javaquickstart.controllersvalidation;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateTodo {

  @NotEmpty
  private final String title;

  @NotNull
  @FutureOrPresent
  private final LocalDate due;

  private final String description;

}
