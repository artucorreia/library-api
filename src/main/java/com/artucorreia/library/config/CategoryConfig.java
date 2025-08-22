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
  public FindAllCategoriesUseCase findAllCategoriesUseCase(
      CategoryRepositoryGateway categoryRepositoryGateway) {
    return new FindAllCategoriesUseCaseImpl(categoryRepositoryGateway);
  }

  @Bean
  public CreateCategoryUseCase createCategoryUseCase(
      CategoryRepositoryJpaGateway categoryRepositoryJpaGateway) {
    return new CreateCategoryUseCaseImpl(categoryRepositoryJpaGateway);
  }

  @Bean
  public UpdateCategoryUseCase updateCategoryUseCase(
      CategoryRepositoryJpaGateway categoryRepositoryJpaGateway,
      FindCategoryByIdUseCaseImpl findCategoryByIdUseCase) {
    return new UpdateCategoryUseCaseImpl(categoryRepositoryJpaGateway, findCategoryByIdUseCase);
  }

  @Bean
  public DeleteCategoryByIdUseCase deleteCategoryByIdUseCase(
      CategoryRepositoryJpaGateway categoryRepositoryJpaGateway,
      FindCategoryByIdUseCaseImpl findCategoryByIdUseCase) {
    return new DeleteCategoryByIdUseCaseImpl(categoryRepositoryJpaGateway, findCategoryByIdUseCase);
  }
}
