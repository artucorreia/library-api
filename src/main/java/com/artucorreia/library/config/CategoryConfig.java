package com.artucorreia.library.config;

import com.artucorreia.library.application.interactors.CreateCategoryUseCaseImpl;
import com.artucorreia.library.application.interactors.DeleteCategoryByIdUseCaseImpl;
import com.artucorreia.library.application.interactors.FindCategoryByIdUseCaseImpl;
import com.artucorreia.library.application.interactors.UpdateCategoryUseCaseImpl;
import com.artucorreia.library.application.usecases.CreateCategoryUseCase;
import com.artucorreia.library.application.usecases.DeleteCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.FindCategoryByIdUseCase;
import com.artucorreia.library.application.usecases.UpdateCategoryUseCase;
import com.artucorreia.library.infra.persistence.jpa.CategoryRepositoryJpaGateway;
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
