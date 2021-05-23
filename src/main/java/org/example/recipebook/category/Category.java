package org.example.recipebook.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.recipebook.recipe.Recipe;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    @ManyToMany(
            mappedBy = "categories",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private Collection<Recipe> recipes = new HashSet<>();

    public Category() {
    }

    public Category(String name, Collection<Recipe> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    public void addRecipes(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return category.id != null && category.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
