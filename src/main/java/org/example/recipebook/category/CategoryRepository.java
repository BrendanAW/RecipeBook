package org.example.recipebook.category;

import java.util.Collection;
import java.util.UUID;


public interface CategoryRepository {
    UUID addCategory(Category category) throws CategoryExistsException;

    Category getById(UUID id) throws CategoryNotFoundException;

    void delete(Category category) throws CategoryNotFoundException;

    Collection<Category> getCategoryList(int startingIndex, int size);

    class CategoryExistsException extends Exception {
        public CategoryExistsException(String message) {
            super(message);
        }
    }

    class CategoryNotFoundException extends Exception {
        public CategoryNotFoundException(String message) {
            super(message);
        }
    }
}
