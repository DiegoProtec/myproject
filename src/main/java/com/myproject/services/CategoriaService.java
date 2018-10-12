package com.myproject.services;

import com.myproject.domains.Categoria;
import com.myproject.repositorys.CategoriaRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoriaService extends AbstractCrudService<Categoria, Long, CategoriaRepository> {

    public CategoriaService(CategoriaRepository repository) {
        super(repository);
    }

    public Stream<Categoria> listar() {
        return super.listar();
    }

    public Categoria categoria(Long id) {
        Optional<Categoria> op = super.buscarPorId(id);
        if (!op.isPresent()) throw new CustomNotFoundException("Categoria, id: " + id + "não encontrado.");
        return op.get();
    }

    @Transactional
    public Optional<Categoria> salvar(Categoria categoria) {
        return super.salvar(categoria);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }

}
