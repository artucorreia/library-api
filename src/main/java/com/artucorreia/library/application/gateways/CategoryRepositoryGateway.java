package com.artucorreia.library.application.gateways;

import com.artucorreia.library.domain.entities.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryGateway {
  Optional<Category> findById(Long id);

  List<Category> findAll();

  void save(Category category);

  void deleteById(Long id);
}
