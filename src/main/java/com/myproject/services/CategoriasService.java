package com.myproject.services;

import com.myproject.domain.Categoria;
import com.myproject.repositorys.CategoriasRepository;
import com.myproject.handler.exceptions.CustomNotFoundException;
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
        categoria.setId(null);
        return categoriasRepository.save(categoria);
    }

    public void atualizar(Categoria categoria) {
        existe(categoria);
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
        categoria(categoria.getId());
    }

}
