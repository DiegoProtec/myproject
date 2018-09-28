package com.myproject.services;

import com.myproject.domain.Categoria;
import com.myproject.repositorys.CategoriasRepository;
import com.myproject.resources.exceptions.CustomExistEntity;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    private CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<Categoria> listar() {
        return categoriasRepository.findAll();
    }

    public Categoria categoria(Long id) {
        Optional<Categoria> op = categoriasRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("id:" + id);
        return op.get();
    }

    public Categoria salvar(Categoria categoria) {
        if (categoria.getId() != null) {
            Optional<Categoria> op = categoriasRepository.findById(categoria.getId());
            if (op.isPresent()) throw new CustomExistEntity("A categoria já existe.");
        }
        return categoriasRepository.save(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.existe(categoria);
        categoriasRepository.save(categoria);
    }

    public void deletar(Long id) {
        try {
            categoriasRepository.deleteById(id);
        } catch (CustomNotFoundException e) {
            throw new CustomNotFoundException("id:" + id);
        }
    }

    private void existe(Categoria categoria) {
        this.categoria(categoria.getId());
    }

}
