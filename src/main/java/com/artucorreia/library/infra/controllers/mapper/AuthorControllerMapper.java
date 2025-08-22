package com.artucorreia.library.infra.controllers.mapper;

import com.artucorreia.library.domain.entities.Author;
import com.artucorreia.library.infra.controllers.dtos.AuthorResponseDTO;
import com.artucorreia.library.infra.controllers.dtos.CreateAuthorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorControllerMapper {

  AuthorResponseDTO domainToResponseDTO(Author author);

  Author createDTOToDomain(CreateAuthorDTO createAuthorDTO);
}
