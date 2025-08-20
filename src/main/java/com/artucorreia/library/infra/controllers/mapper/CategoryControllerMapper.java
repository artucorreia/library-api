package com.artucorreia.library.infra.controllers.mapper;

import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.infra.controllers.dtos.CategoryResponseDTO;
import com.artucorreia.library.infra.controllers.dtos.CreateCategoryDTO;
import com.artucorreia.library.infra.controllers.dtos.UpdateCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryControllerMapper {
  @Mapping(source = "name", target = "name")
  Category createDTOToDomain(CreateCategoryDTO createCategoryDTO);

  CategoryResponseDTO domainToResponseDTO(Category category);

  Category updateDTOToDomain(UpdateCategoryDTO updateCategoryDTO);

}
