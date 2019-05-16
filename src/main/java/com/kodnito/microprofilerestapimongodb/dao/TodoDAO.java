package com.kodnito.microprofilerestapimongodb.dao;

import com.kodnito.microprofilerestapimongodb.model.Todo;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class TodoDAO {

    @Inject
    private EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Todo.findAll", Todo.class).getResultList();
    }

    public Todo findById(String id) {
        return em.find(Todo.class, id);
    }

    public void update(Todo todo) {
        em.getTransaction().begin();
        em.merge(todo);
        em.getTransaction().commit();

    }

    public void create(Todo todo) {
        em.getTransaction().begin();
        em.persist(todo);
        em.getTransaction().commit();
    }

    public void delete(Todo todo) {
        em.getTransaction().begin();
        em.remove(todo);
        em.getTransaction().commit();
    }

}