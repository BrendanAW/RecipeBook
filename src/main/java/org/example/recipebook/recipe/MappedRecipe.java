package org.example.recipebook.recipe;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class MappedRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    private UUID recipeUuid;

    public MappedRecipe() {
    }

    public MappedRecipe(Recipe recipe, UUID recipeUuid) {
        this.recipe = recipe;
        this.recipeUuid = recipeUuid;
    }
}
