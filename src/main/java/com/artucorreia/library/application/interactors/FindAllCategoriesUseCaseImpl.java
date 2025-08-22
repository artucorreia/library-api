package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.FindAllCategoriesUseCase;
import com.artucorreia.library.domain.entities.Category;

import java.util.List;

public class FindAllCategoriesUseCaseImpl implements FindAllCategoriesUseCase {
  private final CategoryRepositoryGateway categoryRepositoryGateway;

  public FindAllCategoriesUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
  }

  @Override
  public List<Category> execute() {
    return categoryRepositoryGateway.findAll();
  }
}
