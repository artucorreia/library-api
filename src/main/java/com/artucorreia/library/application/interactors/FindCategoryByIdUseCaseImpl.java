package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.domain.exceptions.ResourceNotFoundException;

import java.util.Optional;

public class FindCategoryByIdUseCaseImpl implements FindCategoryByIdUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;

  public FindCategoryByIdUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
  }

  @Override
  public Category execute(Long id) {
    Optional<Category> category = categoryRepositoryGateway.findById(id);
    return category.orElseThrow(() -> new ResourceNotFoundException("Category not found"));
  }
}
