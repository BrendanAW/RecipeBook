package org.example.recipebook.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public UUID addCategory(Category category) throws CategoryExistsException {
        try {
            em.persist(category);
            var uuid = UUID.randomUUID();
            CategoryProperties cId = new CategoryProperties(category, uuid);
            em.persist(cId);
            return uuid;
        } catch (EntityExistsException e) {
            throw new CategoryExistsException(e.getMessage());
        }
    }

    @Override
    public Category getById(UUID id) throws CategoryNotFoundException {
        try {
            return em.createQuery("from Category where id in (select cp.id from CategoryProperties cp where cp.categoryId=:id)", Category.class)
                    .setParameter("id", id.toString())
                    .getSingleResult();
        } catch (EntityNotFoundException e) {
            throw new CategoryNotFoundException(e.getMessage());
        }
    }

    @Override
    public void delete(Category category) throws CategoryNotFoundException {
        try {
            em.remove(category);
        } catch (EntityNotFoundException e) {
            throw new CategoryNotFoundException(e.getMessage());
        }
    }


    @Override
    public List<Category> getCategoryList(int startingIndex, int size) {
        try {
            return em.createQuery("from Category ORDER BY id", Category.class)
                    .setFirstResult(startingIndex)
                    .setMaxResults(size)
                    .getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
