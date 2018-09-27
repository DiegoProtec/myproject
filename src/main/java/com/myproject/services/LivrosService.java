package com.myproject.services;

import com.myproject.domain.Livro;
import com.myproject.repositorys.AutoresRepository;
import com.myproject.repositorys.CategoriasRepository;
import com.myproject.repositorys.LivrosRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    private LivrosRepository livrosRepository;
    private CategoriasRepository categoriasRepository;
    private AutoresRepository autoresRepository;

    @Autowired
    public LivrosService(LivrosRepository livrosRepository, CategoriasRepository categoriasRepository, AutoresRepository autoresRepository) {
        this.livrosRepository = livrosRepository;
        this.categoriasRepository = categoriasRepository;
        this.autoresRepository = autoresRepository;
    }

    public List<Livro> listar(){
        return livrosRepository.findAll();
    }

    public Livro livro(Long id){
        Optional<Livro> op = livrosRepository.findById(id);
        if(!op.isPresent()) throw new CustomNotFoundException("id:" + id);
        return op.get();
    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livrosRepository.save(livro);
    }

    public void atualizar(Livro livro) {
        existe(livro);
        livrosRepository.save(livro);
    }

    public void deletar(Long id) {
        try {
            livrosRepository.deleteById(id);
        } catch (CustomNotFoundException e) {
            throw new CustomNotFoundException("id:" + id);
        }
    }

    private void existe(Livro livro){
        livro(livro.getId());
    }
}
