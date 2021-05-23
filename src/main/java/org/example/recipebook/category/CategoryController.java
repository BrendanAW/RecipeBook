package org.example.recipebook.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("")
    public ResponseEntity<Collection<Category>> getCategories(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        return ResponseEntity.ok(categoryService.getCategories(page.orElseThrow(), size.orElse(12)));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable UUID categoryId) {
        try {
            return ResponseEntity.ok(categoryService.getById(categoryId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
