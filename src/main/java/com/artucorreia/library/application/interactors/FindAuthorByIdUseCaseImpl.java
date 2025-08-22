package com.artucorreia.library.application.interactors;

import com.artucorreia.library.application.gateways.AuthorRepositoryGateway;
import com.artucorreia.library.application.usecases.FindAuthorByIdUseCase;
import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.domain.exceptions.ResourceNotFoundException;

public class FindAuthorByIdUseCaseImpl implements FindAuthorByIdUseCase {

  private final AuthorRepositoryGateway authorRepositoryGateway;

  public FindAuthorByIdUseCaseImpl(AuthorRepositoryGateway authorRepositoryGateway) {
    this.authorRepositoryGateway = authorRepositoryGateway;
  }

  @Override
  public Author execute(Long id) {
    return authorRepositoryGateway
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
  }
}
