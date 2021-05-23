package org.example.recipebook.recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeRepository {
    UUID add(Recipe recipe) throws RecipeExistsException;

    Recipe getById(UUID id) throws RecipeNotFoundException;

    void delete(UUID id) throws RecipeNotFoundException;

    List<Recipe> getRecipes(int page, int size);

    class RecipeExistsException extends Exception {
    }

    class RecipeNotFoundException extends Exception {
    }
}
