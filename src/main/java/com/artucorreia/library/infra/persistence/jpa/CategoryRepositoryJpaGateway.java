package com.artucorreia.library.infra.persistence.jpa;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.domain.entities.Category;
import com.artucorreia.library.infra.persistence.mapper.CategoryPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryJpaGateway implements CategoryRepositoryGateway {

  private final CategoryRepository categoryRepository;
  private final CategoryPersistenceMapper categoryPersistenceMapper;

  @Override
  public Optional<Category> findById(Long id) {
    Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
    return categoryEntity.map(categoryPersistenceMapper::entityToDomain);
  }

  @Override
  public List<Category> findAll() {
    return List.of();
  }

  @Override
  public void save(Category category) {
    CategoryEntity categoryEntity = categoryPersistenceMapper.domainToEntity(category);
    categoryRepository.save(categoryEntity);
  }

  @Override
  public void deleteById(Long id) {
    categoryRepository.deleteById(id);
  }
}
