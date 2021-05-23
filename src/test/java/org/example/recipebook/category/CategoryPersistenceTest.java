package org.example.recipebook.category;

import org.example.recipebook.recipe.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootTest
public class CategoryPersistenceTest {
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        em = Persistence.createEntityManagerFactory("test")
                .createEntityManager();
    }

    @Test
    public void saveCategory() {
        em.getTransaction().begin();
        Category c = new Category("Gim", List.of(new Recipe()));
        em.persist(c);
        em.getTransaction().commit();
        var newC = em.createQuery("from Category", Category.class).getSingleResult();
        Assertions.assertEquals(c, newC);
    }
}
