package org.acme.repository.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "fruit")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FruitEntity extends PanacheEntity {

    //@Id
    //@GeneratedValue
    private Long id;
    private String name;
    private String description;
}
