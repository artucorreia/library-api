package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.UpdateCategoryUseCase;
import com.artucorreia.library.domain.entities.Category;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;
  private final FindCategoryByIdUseCase findCategoryByIdUseCase;

  public UpdateCategoryUseCaseImpl(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByIdUseCase findCategoryByIdUseCase) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
    this.findCategoryByIdUseCase = findCategoryByIdUseCase;
  }

  @Override
  public void execute(Long id, Category newValues) {
    Category category = findCategoryByIdUseCase.execute(id);
    if (newValues.getName() != null && newValues.getName() != category.getName()) {
      category.setName(newValues.getName());
    }
    categoryRepositoryGateway.save(category);
  }
}
