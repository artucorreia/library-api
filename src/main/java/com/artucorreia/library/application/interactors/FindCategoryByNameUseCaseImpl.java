package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.FindCategoryByNameUseCase;
import com.artucorreia.library.domain.entities.Category;

import java.util.Optional;

public class FindCategoryByNameUseCaseImpl implements FindCategoryByNameUseCase {
  private final CategoryRepositoryGateway categoryRepositoryGateway;

  public FindCategoryByNameUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
  }

  @Override
  public Optional<Category> execute(String name) {
    return categoryRepositoryGateway.findByName(name.trim().toUpperCase());
  }
}
