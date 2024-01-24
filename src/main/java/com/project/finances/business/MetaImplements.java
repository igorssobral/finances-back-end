package com.project.finances.business;

import com.project.finances.business.interfaces.MetaService;
import com.project.finances.model.entity.Meta;
import com.project.finances.model.repository.MetaDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaImplements implements MetaService {

    @Autowired
    private MetaDAORepository metaRepository;

    @Override
    public Meta save(Meta meta) {
        if (meta.getId() != null) {
            throw new IllegalStateException("The user already exists in the database.");
        }

        return metaRepository.save(meta);
    }

    @Override
    public Meta update(Meta meta) {
        if (meta.getId() == null) {
            throw new IllegalStateException("Id cannot be null");
        }
        return metaRepository.save(meta);
    }

    @Override
    public List<Meta> find(Meta filter) {

        Example<Meta> filters = Example.of(filter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));


        return metaRepository.findAll(filters);
    }

    @Override
    public List<Meta> findAll() {
        return metaRepository.findAll();
    }

    @Override
    public Meta findByName(String name) {

        if (name == null) {
            throw new IllegalStateException("Name cannot be null!");
        }

        Meta metaFind = null;

        List<Meta> allMetas = metaRepository.findAll();
        for (int i = 0; i < allMetas.size(); i++) {
            if (allMetas.get(i).getName().equals(name)) {
                metaFind = allMetas.get(i);
            }
        }

        return metaFind;
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
        }

        Meta meta = findById(id);

        if (meta == null) {
            throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
        }
        metaRepository.delete(meta);
    }

    @Override
    public Meta findById(Long id) {

        if (id == null) {
            throw new IllegalStateException("Id cannot be null!");
        }

        Optional<Meta> optional = metaRepository.findById(id);


        return optional.isPresent() ? optional.get() : null;
    }
}