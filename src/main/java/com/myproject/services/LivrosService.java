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

@Service
public class LivrosService {

    private LivrosRepository livrosRepository;

    @Autowired
    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    public Livro livro(Long id) {
        Optional<Livro> op = livrosRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("id:" + id);
        return op.get();
    }

    public Livro salvar(Livro livro) {
        if (livro.getId() != null) {
            Optional<Livro> op = livrosRepository.findById(livro.getId());
            if (op.isPresent()) throw new CustomExistEntity("O livro já existe.");
        }
        return livrosRepository.save(livro);
    }

    public void atualizar(Livro livro) {
        this.existe(livro);
        livrosRepository.save(livro);
    }

    public void atualizarAutores(Livro livro, List<Autor> autores) {
        for (Autor autor : autores) {
            livro.addAutor(autor);
        }
        livrosRepository.save(livro);
    }

    public void atualizarCategorias(Livro livro, List<Categoria> categorias) {
        for (Categoria categoria : categorias) {
            livro.addCategoria(categoria);
        }
        livrosRepository.save(livro);
    }

    public void deletar(Long id) {
        try {
            livrosRepository.deleteById(id);
        } catch (CustomNotFoundException e) {
            throw new CustomNotFoundException("id:" + id);
        }
    }


    private void existe(Livro livro) {
        this.livro(livro.getId());
    }
}
