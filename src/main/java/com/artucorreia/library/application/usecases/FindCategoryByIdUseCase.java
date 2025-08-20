package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Category;

public interface FindCategoryByIdUseCase {
  Category execute(Long id);
}
