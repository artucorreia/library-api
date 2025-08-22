package com.artucorreia.library.application.gateways;

import com.artucorreia.library.domain.entities.Author;

import java.util.Optional;

public interface AuthorRepositoryGateway {
  void save(Author author);

  Optional<Author> findByName(String name);
}
