package com.artucorreia.library.application.gateways;

import com.artucorreia.library.domain.entities.Category;
import java.util.List;

public interface CategoryRepositoryGateway {
  Category findById(Integer id);

  List<Category> findAll();

  void save(Category category);
}
