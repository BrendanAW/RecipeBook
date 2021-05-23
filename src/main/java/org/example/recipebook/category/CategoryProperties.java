package org.example.recipebook.category;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class CategoryProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Category category;
    private UUID categoryUuid;

    public CategoryProperties() {
    }

    public CategoryProperties(Category category, UUID categoryUuid) {
        this.category = category;
        this.categoryUuid = categoryUuid;
    }
}
