package org.gdas.bigreportsworker.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "any_entity")
public class AnyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "any_field")
    private String anyField;

    public AnyEntity(String anyField) {
        this.anyField = anyField;
    }

    @Override
    public String toString() {
        return "AnyEntity{" +
                "id=" + id +
                ", anyField='" + anyField + '\'' +
                '}';
    }
}
