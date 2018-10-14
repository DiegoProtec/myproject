package com.myproject.services;

import com.myproject.domains.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class AbstractCrudService<E extends BaseEntity<I>, I extends Serializable, R extends CrudRepository<E, I>> extends AbstractService<E, I, R> {

    AbstractCrudService(R repository) {
        super(repository);
    }

    public E salvar(E entidade) {
        return repository.save(entidade);
    }

    public Iterable<E> salvar(Iterable<E> entidades) {
        return repository.saveAll(entidades);
    }

    public void deletar(I id) {
        repository.deleteById(id);
    }

    public void deletar(E entidade) {
        repository.delete(entidade);
    }

}
