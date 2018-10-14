package com.myproject.services;

import com.myproject.domains.Funcionario;
import com.myproject.repositorys.FuncionarioRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FuncionarioService extends AbstractCrudService<Funcionario, Long, FuncionarioRepository> {

    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }

    public Stream<Funcionario> listar() {
        return super.listar();
    }

    public Funcionario funcionario(Long id) {
        Optional<Funcionario> funcionario = Optional.of(super.buscarPorId(id));
        if (!funcionario.isPresent()) throw new CustomNotFoundException("Funcionário, id: " + id + "não encontrado.");
        return funcionario.get();
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario) {
        return super.salvar(funcionario);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }
}
