package com.myproject.services;

import com.myproject.domains.Livro;
import com.myproject.repositorys.LivroRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LivroService extends AbstractCrudService<Livro, Long, LivroRepository> {

    public LivroService(LivroRepository repository) {
        super(repository);
    }

    public Stream<Livro> listar() {
        return super.listar();
    }

    public Optional<Livro> livro(Long id) {
        Optional<Livro> livro = super.buscarPorId(id);
        if (!livro.isPresent()) throw new CustomNotFoundException("Livro, id: " + id + "não encontrado.");
        return livro;
    }

    @Transactional
    public Optional<Livro> salvar(Livro livro) {
        return super.salvar(livro);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }

}
