package com.artucorreia.library.config;

import com.artucorreia.library.application.interactors.*;
import com.artucorreia.library.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

  @Bean
  public FindCategoryByIdUseCase findCategoryByIdUseCase(
      CategoryRepositoryJpaGateway categoryRepositoryJpaGateway) {
    return new FindCategoryByIdUseCaseImpl(categoryRepositoryJpaGateway);
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
      CategoryRepositoryJpaGateway categoryRepositoryJpaGateway,
      FindCategoryByIdUseCaseImpl findCategoryByIdUseCase) {
    return new DeleteCategoryByIdUseCaseImpl(categoryRepositoryJpaGateway, findCategoryByIdUseCase);
  }
}
