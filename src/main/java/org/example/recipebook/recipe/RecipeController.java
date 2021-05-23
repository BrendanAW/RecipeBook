package org.example.recipebook.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import static org.example.recipebook.recipe.RecipeRepository.RecipeExistsException;
import static org.example.recipebook.recipe.RecipeRepository.RecipeNotFoundException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    @PostMapping("")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
        //leave invalid data to front end team, they're lazy anyways
        try {
            recipeService.add(recipe);
            return ResponseEntity.created(new URI("http://0.0.0.0/recipes")).build();
        } catch (RecipeExistsException | URISyntaxException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable UUID recipeId) {
        try {
            recipeService.delete(recipeId);
            return ResponseEntity.noContent().build();
        } catch (RecipeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable UUID recipeId) {
        try {
            return ResponseEntity.ok(recipeService.getById(recipeId));
        } catch (RecipeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe, @PathVariable UUID recipeId) {
        try {
            var updatedRecipe = recipeService.update(recipeId, recipe);
            return ResponseEntity.ok(updatedRecipe);
        } catch (RecipeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping(
            value = "/{recipeId}/image",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    byte[] getImage(@PathVariable UUID recipeId) {
        try {
            return recipeService.getRecipeImage(recipeId);
        } catch (IOException | RecipeNotFoundException e) {
            return new byte[]{};
        }
    }
}
