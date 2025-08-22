package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Author;

import java.util.Optional;

public interface FindAuthorByNameUseCase {
  Optional<Author> execute(String name);
}
