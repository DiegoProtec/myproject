package com.myproject.services;

import com.myproject.domains.Autor;
import com.myproject.repositorys.AutorRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AutorService extends AbstractCrudService<Autor, Long, AutorRepository> {

    public AutorService(AutorRepository repository) {
        super(repository);
    }

    public Stream<Autor> listar() {
        return super.listar();
    }

    public Optional<Autor> autor(Long id) {
        Optional<Autor> autor = super.buscarPorId(id);
        if (!autor.isPresent()) throw new CustomNotFoundException("Autor, id: " + id + "não encontrado.");
        return autor;
    }

    @Transactional
    public Optional<Autor> salvar(Autor autor) {
        return super.salvar(autor);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }

}