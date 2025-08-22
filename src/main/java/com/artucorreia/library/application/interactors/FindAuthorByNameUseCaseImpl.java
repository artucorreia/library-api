package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.AuthorRepositoryGateway;
import com.artucorreia.library.application.usecases.FindAuthorByNameUseCase;
import com.artucorreia.library.domain.entities.Author;

import java.util.Optional;
import java.util.logging.Logger;

public class FindAuthorByNameUseCaseImpl implements FindAuthorByNameUseCase {

  private final AuthorRepositoryGateway authorRepositoryGateway;
  private final Logger LOGGER = Logger.getLogger(FindAuthorByNameUseCaseImpl.class.getName());

  public FindAuthorByNameUseCaseImpl(AuthorRepositoryGateway authorRepositoryGateway) {
    this.authorRepositoryGateway = authorRepositoryGateway;
  }

  @Override
  public Optional<Author> execute(String name) {
    LOGGER.info("Finding a author by name");
    return authorRepositoryGateway.findByName(name.trim());
  }
}
