package com.artucorreia.library.infra.controllers.mapper;

import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.controllers.dtos.CreateAuthorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorControllerMapper {
  Author createDTOToDomain(CreateAuthorDTO createAuthorDTO);
}
