package com.project.finances.presentation.dto;

import jakarta.persistence.Column;

public class MetaDTO {

    private Long id;
    private String name;
    private Double valueMeta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
