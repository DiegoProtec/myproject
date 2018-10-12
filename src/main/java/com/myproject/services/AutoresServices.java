package com.myproject.services;

import com.myproject.domains.Autor;
import com.myproject.repositorys.AutoresRepository;
import com.myproject.resources.exceptions.CustomExistEntityException;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresServices {

    private AutoresRepository autoresRepository;

    @Autowired
    public AutoresServices(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    public List<Autor> listar() {
        return this.autoresRepository.findAll();
    }

    public Autor autor(Long id) {
        Optional<Autor> op = this.autoresRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("id: " + id);
        return op.get();
    }

    public Autor salvar(Autor autor) {
        if (autor.getId() != null) {
            Optional<Autor> op = this.autoresRepository.findById(autor.getId());
            if (op.isPresent()) throw new CustomExistEntityException("O autor já existe.");
        }
        return this.autoresRepository.save(autor);
    }

    public void atualizar(Autor autor) {
        this.existe(autor);
        this.autoresRepository.save(autor);
    }

    public void deletar(Long id) {
        Autor autor = this.autor(id);
        this.autoresRepository.delete(autor);
    }

    void existe(Autor autor) {
        this.autor(autor.getId());
    }

}
