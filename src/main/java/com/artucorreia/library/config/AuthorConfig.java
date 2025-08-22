package com.artucorreia.library.config;

import com.artucorreia.library.application.gateways.AuthorRepositoryGateway;
import com.artucorreia.library.application.interactors.FindAuthorByNameUseCaseImpl;
import com.artucorreia.library.application.usecases.FindAuthorByNameUseCase;
import com.artucorreia.library.infra.persistence.jpa.AuthorJpaRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfig {

  @Bean
  public FindAuthorByNameUseCase findAuthorByNameUseCase(
      AuthorRepositoryGateway authorRepositoryGateway) {
    return new FindAuthorByNameUseCaseImpl(authorRepositoryGateway);
  }
}
