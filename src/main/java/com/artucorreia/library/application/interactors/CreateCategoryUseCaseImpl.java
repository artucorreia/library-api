package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.CreateCategoryUseCase;
import com.artucorreia.library.domain.entities.Category;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;

  public CreateCategoryUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
  }

  @Override
  public void execute(Category category) {
      category.setName(category.getName().trim().toUpperCase());
      categoryRepositoryGateway.save(category);
  }
}
