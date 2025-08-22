package com.artucorreia.library.config;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.application.interactors.*;
import com.artucorreia.library.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

  @Bean
  public FindCategoryByIdUseCase findCategoryByIdUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway) {
    return new FindCategoryByIdUseCaseImpl(categoryRepositoryGateway);
  }

  @Bean
  public FindCategoryByNameUseCase findCategoryByNameUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway) {
    return new FindCategoryByNameUseCaseImpl(categoryRepositoryGateway);
  }

  @Bean
  public FindAllCategoriesUseCase findAllCategoriesUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway) {
    return new FindAllCategoriesUseCaseImpl(categoryRepositoryGateway);
  }

  @Bean
  public CreateCategoryUseCase createCategoryUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByNameUseCase findCategoryByNameUseCase) {
    return new CreateCategoryUseCaseImpl(categoryRepositoryGateway, findCategoryByNameUseCase);
  }

  @Bean
  public UpdateCategoryUseCase updateCategoryUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByIdUseCase findCategoryByIdUseCase,
      FindCategoryByNameUseCase findCategoryByNameUseCase) {
    return new UpdateCategoryUseCaseImpl(
        categoryRepositoryGateway, findCategoryByIdUseCase, findCategoryByNameUseCase);
  }

  @Bean
  public DeleteCategoryByIdUseCase deleteCategoryByIdUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway,
      FindCategoryByIdUseCase findCategoryByIdUseCase) {
    return new DeleteCategoryByIdUseCaseImpl(categoryRepositoryGateway, findCategoryByIdUseCase);
  }
}
