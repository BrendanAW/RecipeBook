package org.example.recipebook.category;

import java.util.Collection;
import java.util.UUID;

public interface CategoryService {
    Collection<Category> getCategories(int page, int size);
    Category getById(UUID id) throws CategoryRepositoryImpl.CategoryNotFoundException;
}
