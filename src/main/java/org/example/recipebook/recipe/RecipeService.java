package org.example.recipebook.recipe;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.example.recipebook.recipe.RecipeRepository.RecipeExistsException;
import static org.example.recipebook.recipe.RecipeRepository.RecipeNotFoundException;

public interface RecipeService {
    void add(Recipe recipe) throws RecipeExistsException;

    void delete(UUID id) throws RecipeNotFoundException;

    Recipe update(UUID id, Recipe recipe) throws RecipeNotFoundException;

    Recipe getById(UUID id) throws RecipeNotFoundException;

    List<Recipe> getRecipes(int page, int size);

    byte[] getRecipeImage(UUID id) throws IOException, RecipeNotFoundException;
}
