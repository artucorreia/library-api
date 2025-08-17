package com.artucorreia.library.application.usecases;

import com.artucorreia.library.domain.entities.Category;

public interface CreateCategoryUseCase {
    void execute(Category category);
}
