package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Category;

public interface UpdateCategoryUseCase {
  void execute(Long id, Category newValues);
}
