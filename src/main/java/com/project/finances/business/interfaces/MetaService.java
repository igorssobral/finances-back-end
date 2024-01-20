package com.project.finances.business.interfaces;

import com.project.finances.model.entity.Meta;

import java.util.List;

public interface MetaService {
    public Meta save(Meta meta);

    public Meta update(Meta meta);

    public List<Meta> find(Meta meta);

    public List<Meta> findAll();

    public List<Meta> findByName(String name);

    public void delete(Long id);

    public Meta findById(Long id);


}
