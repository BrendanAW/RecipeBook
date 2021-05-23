package org.example.recipebook.shoppinglist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingListItemService {
    private final ShoppingListItemRepository shoppingListItemRepository;

    public List<ShoppingListItem> getAllShoppingListItems() {
        return shoppingListItemRepository.findAll();
    }

    public void add(ShoppingListItem listItem) {
        shoppingListItemRepository.save(listItem);
    }

    public void updateShoppingList(List<ShoppingListItem> shoppingListItems) {
        List<ShoppingListItem> toDelete = shoppingListItems.stream().filter(ShoppingListItem::isRemovable).collect(Collectors.toList());
        toDelete.forEach(shoppingListItemRepository::delete);
        shoppingListItems.removeAll(toDelete);

        shoppingListItemRepository.saveAll(shoppingListItems);
    }
}
