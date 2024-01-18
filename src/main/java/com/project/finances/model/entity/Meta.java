package com.project.finances.model.entity;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Meta {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double valueMeta;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValueMeta() {
        return valueMeta;
    }

    public void setValueMeta(Double valueMeta) {
        this.valueMeta = valueMeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return Objects.equals(id, meta.id) && Objects.equals(name, meta.name) && Objects.equals(valueMeta, meta.valueMeta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, valueMeta);
    }
}
