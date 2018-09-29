package com.myproject.services;

import com.myproject.domain.Autor;
import com.myproject.domain.Categoria;
import com.myproject.domain.Livro;
import com.myproject.repositorys.LivrosRepository;
import com.myproject.resources.exceptions.CustomExistEntity;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LivrosService {

    private LivrosRepository livrosRepository;
    private AutoresServices autoresServices;
    private CategoriasService categoriasService;

    @Autowired
    public LivrosService(LivrosRepository livrosRepository, AutoresServices autoresServices, CategoriasService categoriasService) {
        this.livrosRepository = livrosRepository;
        this.autoresServices = autoresServices;
        this.categoriasService = categoriasService;
    }

    public List<Livro> listar() {
        return this.livrosRepository.findAll();
    }

    public Livro livro(Long id) {
        Optional<Livro> op = this.livrosRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("id:" + id);
        return op.get();
    }

    public Livro salvar(Livro livro) {
        if (livro.getId() != null) {
            Optional<Livro> op = this.livrosRepository.findById(livro.getId());
            if (op.isPresent()) throw new CustomExistEntity("O livro já existe.");
        }
        return this.livrosRepository.save(livro);
    }

    public void atualizar(Livro livro) {
        this.existe(livro);
        this.livrosRepository.save(livro);
    }

    public void atualizarAutores(Livro livro, Set<Autor> autores) {
        this.existe(livro);
        for (Autor autor : autores) {
            this.autoresServices.existe(autor);
        }
        livro.setAutores(autores);
        this.livrosRepository.save(livro);
    }

    public void atualizarCategorias(Livro livro, Set<Categoria> categorias) {
        this.existe(livro);
        for (Categoria categoria : categorias) {
            this.categoriasService.existe(categoria);
        }
        livro.setCategorias(categorias);
        this.livrosRepository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = this.livro(id);
        this.livrosRepository.delete(livro);
    }

    private void existe(Livro livro) {
        this.livro(livro.getId());
    }

}
