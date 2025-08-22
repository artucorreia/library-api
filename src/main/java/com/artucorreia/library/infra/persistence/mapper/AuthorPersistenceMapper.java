package com.artucorreia.library.infra.persistence.mapper;

import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.persistence.jpa.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorPersistenceMapper {
  Author entityToDomain(AuthorEntity authorEntity);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  AuthorEntity domainToEntity(Author author);
}
