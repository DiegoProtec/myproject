package com.myproject.services;

import com.myproject.domains.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class AbstractService<E extends BaseEntity<I>, I extends Serializable, R extends CrudRepository<E, I>> {

    protected final R repository;

    AbstractService(R repository) {
        super();
        this.repository = repository;
    }

    public Stream<E> listar() {
        return toStream(repository.findAll());
    }

    public Optional<E> buscarPorId(I id) {
        return repository.findById(id);
    }


    protected Stream<E> toStream(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
