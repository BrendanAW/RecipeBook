package org.example.recipebook.recipe;

import javax.persistence.*;


@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String preparation;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private Measurement measurement;

    @ManyToOne
    Recipe recipe;

}
