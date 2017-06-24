package br.com.crescer.locadora_jpa;

import java.util.List;

public interface CrudDao<Entity, ID> {
    
    Entity save(Entity e);

    void remove(Entity e);

    Entity loadById(ID id);

    List<Entity> findAll(); 
}