package com.artucorreia.library.infra.persistence.mapper;

import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.infra.persistence.jpa.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryPersistenceMapper {

  @Mapping(source = "name", target = "name")
  Category entityToDomain(CategoryEntity categoryEntity);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  CategoryEntity domainToEntity(Category category);
}
