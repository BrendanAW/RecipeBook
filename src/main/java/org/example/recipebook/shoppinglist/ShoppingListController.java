package org.example.recipebook.shoppinglist;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/todo")
public class ShoppingListController {
    private final ShoppingListItemService shoppingListItemService;

    @GetMapping("")
    public ResponseEntity<List<ShoppingListItem>> getAllShoppingListItems() {
        return ResponseEntity.ok(shoppingListItemService.getAllShoppingListItems());
    }

    @PostMapping("")
    public ResponseEntity<Object> createTodoListItem(@RequestBody ShoppingListItem shoppingListItemDto) {
        shoppingListItemService.add(shoppingListItemDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "")
    public ResponseEntity<List<ShoppingListItem>> updateShoppingList(@RequestBody List<ShoppingListItem> shoppingListItemDtoList) throws JsonProcessingException {
        try {
            shoppingListItemService.updateShoppingList(shoppingListItemDtoList);
            return ResponseEntity.ok(shoppingListItemService.getAllShoppingListItems());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
