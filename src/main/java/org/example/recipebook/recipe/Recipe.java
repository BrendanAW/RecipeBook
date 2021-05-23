package org.example.recipebook.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.recipebook.category.Category;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Ingredient> ingredients;
    @JsonProperty
    @ElementCollection
    private List<String> instructions;
    @JsonProperty
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Recipes_Categories",
            joinColumns = {@JoinColumn(name = "recipe_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    List<Category> categories;
    @JsonProperty
    String imageLocation;
    @JsonProperty
    private Integer portionSize;
    @JsonProperty
    private String timeToMake;

    public void update(Recipe recipe) {
        this.name = recipe.name;
        this.ingredients = recipe.ingredients;
        this.instructions = recipe.instructions;
        this.categories = recipe.categories;
        this.imageLocation = recipe.imageLocation;
        this.portionSize = recipe.portionSize;
        this.timeToMake = recipe.timeToMake;
    }
}
