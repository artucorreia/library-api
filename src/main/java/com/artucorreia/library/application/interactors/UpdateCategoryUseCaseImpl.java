package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.FindCategoryByNameUseCase;
import com.artucorreia.library.application.usecases.UpdateCategoryUseCase;
import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.domain.exceptions.ResourceAlreadyExistsException;

import java.util.Optional;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

  private final CategoryRepositoryGateway categoryRepositoryGateway;
  private final FindCategoryByIdUseCase findCategoryByIdUseCase;
  private final FindCategoryByNameUseCase findCategoryByNameUseCase;

  public UpdateCategoryUseCaseImpl(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByIdUseCase findCategoryByIdUseCase,
      FindCategoryByNameUseCase findCategoryByNameUseCase) {
    this.categoryRepositoryGateway = categoryRepositoryGateway;
    this.findCategoryByIdUseCase = findCategoryByIdUseCase;
    this.findCategoryByNameUseCase = findCategoryByNameUseCase;
  }

  @Override
  public void execute(Long id, Category newValues) {
    Category category = findCategoryByIdUseCase.execute(id);
    newValues.setName(newValues.getName().trim().toUpperCase());

    Optional<Category> categoryOptional = findCategoryByNameUseCase.execute(newValues.getName());
    boolean categoryAlreadyExists = categoryOptional.isPresent();
    boolean categoriesAreNotEquals = categoryAlreadyExists && !categoryOptional.get().equals(category);
    if (categoryAlreadyExists && categoriesAreNotEquals)
      throw new ResourceAlreadyExistsException("This category already exists");

    if (newValues.getName() != null && !newValues.getName().equals(category.getName())) {
      category.setName(newValues.getName());
    }
    categoryRepositoryGateway.save(category);
  }
}
