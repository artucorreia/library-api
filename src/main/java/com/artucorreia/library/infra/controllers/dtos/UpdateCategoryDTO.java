package com.artucorreia.library.infra.controllers.dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateCategoryDTO {
  @Size(min = 3, max = 50, message = "the category name must be between 3 and 50 characters long")
  private String name;
}
