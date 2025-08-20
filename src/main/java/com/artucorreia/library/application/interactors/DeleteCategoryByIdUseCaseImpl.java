package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.DeleteCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.domain.entities.Category;

public class DeleteCategoryByIdUseCaseImpl implements DeleteCategoryByIdUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;
  private final FindCategoryByIdUseCase findCategoryByIdUseCase;

  public DeleteCategoryByIdUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway, FindCategoryByIdUseCase findCategoryByIdUseCase) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
    this.findCategoryByIdUseCase = findCategoryByIdUseCase;
  }

  @Override
  public void execute(Long id) {
    findCategoryByIdUseCase.execute(id);
    categoryRepositoryGateway.deleteById(id);
  }
}
