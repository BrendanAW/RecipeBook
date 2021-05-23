package org.example.recipebook.category;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

import static org.example.recipebook.category.CategoryRepositoryImpl.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    public Collection<Category> getCategories(int page, int size) {
        int startingIndex = (page - 1) * 10;
        return repository.getCategoryList(startingIndex, size);
    }

    public Category getById(UUID categoryId) throws CategoryNotFoundException {
        return repository.getById(categoryId);
    }


}
