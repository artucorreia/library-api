package com.artucorreia.library.infra.persistence.jpa;

import com.artucorreia.library.application.gateways.AuthorRepositoryGateway;
import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.persistence.mapper.AuthorPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorJpaRepositoryGateway implements AuthorRepositoryGateway {
  private final AuthorRepository authorRepository;
  private final AuthorPersistenceMapper authorPersistenceMapper;

  @Override
  public Optional<Author> findById(Long id) {
    Optional<AuthorEntity> authorEntity = authorRepository.findById(id);
    return authorEntity.map(authorPersistenceMapper::entityToDomain);
  }

  @Override
  public void save(Author author) {
    AuthorEntity authorEntity = authorPersistenceMapper.domainToEntity(author);
    authorRepository.save(authorEntity);
  }

  @Override
  public Optional<Author> findByName(String name) {
    Optional<AuthorEntity> authorEntity = authorRepository.findByNameIgnoreCase(name);
    return authorEntity.map(authorPersistenceMapper::entityToDomain);
  }
}
