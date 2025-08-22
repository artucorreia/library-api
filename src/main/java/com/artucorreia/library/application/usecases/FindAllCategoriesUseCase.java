package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Category;

import java.util.List;

public interface FindAllCategoriesUseCase {
  List<Category> execute();
}
