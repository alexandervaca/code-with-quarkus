package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.repository.entity.FruitEntity;

import java.util.List;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<FruitEntity> {

    public List<FruitEntity> findByName(String name){
        return list("name", name);
    }

}
