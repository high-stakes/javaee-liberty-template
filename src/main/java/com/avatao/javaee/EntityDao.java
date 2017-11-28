package com.avatao.javaee;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Dependent
@Transactional
public class EntityDao {

    @PersistenceContext
    EntityManager em;

    public Entity create(String id, String name) {
        Entity entity = new Entity();
        entity.setId(id);
        entity.setName(name);
        em.persist(entity);

        return entity;
    }

    public Entity read(String id) {
        return em.find(Entity.class, id);
    }

    public Entity update(String id, String name) {
        Entity entity = read(id);

        if (entity == null) {
            entity = new Entity();
        }

        entity.setId(id);
        entity.setName(name);
        return em.merge(entity);
    }
}
