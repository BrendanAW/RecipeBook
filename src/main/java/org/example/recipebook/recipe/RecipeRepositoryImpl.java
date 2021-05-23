package org.example.recipebook.recipe;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {
    @Override
    public UUID add(Recipe recipe) throws RecipeExistsException {
        return null;
    }

    @Override
    public Recipe getById(UUID id) throws RecipeNotFoundException {
        return null;
    }

    @Override
    public void delete(UUID id) throws RecipeNotFoundException {

    }

    @Override
    public List<Recipe> getRecipes(int page, int size) {
        return null;
    }

}
