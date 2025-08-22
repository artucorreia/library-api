package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Author;

public interface CreateAuthorUseCase {
  void execute(Author author);
}
