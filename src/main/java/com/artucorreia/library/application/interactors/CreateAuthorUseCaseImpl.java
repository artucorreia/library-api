package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.AuthorRepositoryGateway;
import com.artucorreia.library.application.usecases.CreateAuthorUseCase;
import com.artucorreia.library.application.usecases.FindAuthorByNameUseCase;
import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.domain.exceptions.ResourceAlreadyExistsException;

import java.util.logging.Logger;

public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {

  private final AuthorRepositoryGateway authorRepositoryGateway;
  private final FindAuthorByNameUseCase findAuthorByNameUseCase;
  private final Logger LOGGER = Logger.getLogger(CreateAuthorUseCaseImpl.class.getName());


  public CreateAuthorUseCaseImpl(
      AuthorRepositoryGateway authorRepositoryGateway,
      FindAuthorByNameUseCase findAuthorByNameUseCase) {
    this.authorRepositoryGateway = authorRepositoryGateway;
    this.findAuthorByNameUseCase = findAuthorByNameUseCase;
  }

  @Override
  public void execute(Author author) {
    LOGGER.info("Creating a new author");
    boolean authorAlreadyExists = findAuthorByNameUseCase.execute(author.getName().trim()).isPresent();
    if (authorAlreadyExists) throw new ResourceAlreadyExistsException("This author already exists");

    author.setName(author.getName().trim());
    authorRepositoryGateway.save(author);
  }
}
