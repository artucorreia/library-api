package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Category;

import java.util.Optional;

public interface FindCategoryByNameUseCase {
  Optional<Category> execute(String name);
}
