package com.myproject.services;

import com.myproject.domain.Autor;
import com.myproject.repositorys.AutoresRepository;
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

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    public Autor autor(Long id){
        Optional<Autor> op = autoresRepository.findById(id);
        if(!op.isPresent()) throw new CustomNotFoundException("id:" + id);
        return op.get();
    }

    public Autor salvar(Autor autor){
        autor.setId(null);
        return autoresRepository.save(autor);
    }

    public void atualizar(Autor autor){
        existe(autor);
        autoresRepository.save(autor);
    }

    public void deletar(Long id){
        try {
            autoresRepository.deleteById(id);
        } catch (CustomNotFoundException e) {
            throw new CustomNotFoundException("id:" + id);
        }
    }

    private void existe(Autor autor){
        autor(autor.getId());
    }

}
