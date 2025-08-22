package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.CreateCategoryUseCase;
import com.artucorreia.library.application.usecases.FindCategoryByNameUseCase;
import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.domain.exceptions.ResourceAlreadyExistsException;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;
  private final FindCategoryByNameUseCase findCategoryByNameUseCase;

  public CreateCategoryUseCaseImpl(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByNameUseCase findCategoryByNameUseCase) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
    this.findCategoryByNameUseCase = findCategoryByNameUseCase;
  }

  @Override
  public void execute(Category category) {
    category.setName(category.getName().trim().toUpperCase());
    boolean categoryAlreadyExists = findCategoryByNameUseCase.execute(category.getName()).isPresent();
    if (categoryAlreadyExists) throw new ResourceAlreadyExistsException("This category already exists");
    categoryRepositoryGateway.save(category);
  }
}
