package org.example.recipebook;

import lombok.RequiredArgsConstructor;
import org.example.recipebook.recipe.Recipe;
import org.example.recipebook.recipe.RecipeServiceImpl;
import org.example.recipebook.shoppinglist.ShoppingListItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class RecipeBookController {
    private final RecipeServiceImpl recipeService;
    private final ShoppingListItemService shoppingListItemService;

    @GetMapping("")
    public ResponseEntity<Collection<Recipe>> getAllRecipes(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        return ResponseEntity.ok(recipeService.getRecipes(page.orElse(1), size.orElse(10)));
    }

//    @GetMapping("/todo")
//    public ResponseEntity<Collection<ShoppingListItem>> getAllShoppingListItems() {
//        return ResponseEntity.ok(shoppingListItemService.getAllShoppingListItems());
//    }
}
