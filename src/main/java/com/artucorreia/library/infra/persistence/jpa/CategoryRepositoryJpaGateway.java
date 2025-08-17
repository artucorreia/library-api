package com.artucorreia.library.infra.persistence.jpa;

import com.artucorreia.library.application.gateways.CategoryRepositoryGateway;
import com.artucorreia.library.domain.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryJpaGateway implements CategoryRepositoryGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public void save(Category category) {

    }
}
