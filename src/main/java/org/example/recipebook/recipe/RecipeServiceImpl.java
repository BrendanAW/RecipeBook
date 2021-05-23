package org.example.recipebook.recipe;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import static org.example.recipebook.recipe.RecipeRepository.RecipeExistsException;
import static org.example.recipebook.recipe.RecipeRepository.RecipeNotFoundException;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public void add(Recipe recipe) throws RecipeExistsException {
        recipe.categories.forEach(c -> c.addRecipes(recipe));
        recipe.ingredients.forEach(i -> i.recipe = recipe);
        recipeRepository.add(recipe);
    }

    public void delete(UUID id) throws RecipeNotFoundException {
        recipeRepository.delete(id);
    }

    public Recipe update(UUID uuid, Recipe recipe) throws RecipeNotFoundException {
        var oldRecipe = recipeRepository.getById(uuid);
        oldRecipe.update(recipe);
        return oldRecipe;
    }

    public Recipe getById(UUID id) throws RecipeNotFoundException {
        return recipeRepository.getById(id);
    }

    public List<Recipe> getRecipes(int pageNumber, int size) {
        int initialIndex = (pageNumber - 1) * 10;
        return recipeRepository.getRecipes(initialIndex, size);
    }

    public byte[] getRecipeImage(UUID recipeId) throws IOException, RecipeNotFoundException {
        var recipe = recipeRepository.getById(recipeId);
        InputStream in = getClass().getResourceAsStream(recipe.imageLocation);
        return IOUtils.toByteArray(in);
    }
}
