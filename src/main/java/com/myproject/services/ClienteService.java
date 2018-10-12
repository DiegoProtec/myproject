package com.myproject.services;

import com.myproject.domains.Cliente;
import com.myproject.repositorys.ClienteRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClienteService extends AbstractCrudService<Cliente, Long, ClienteRepository> {

    public ClienteService(ClienteRepository repository) {
        super(repository);
    }

    public Stream<Cliente> listar() {
        return super.listar();
    }

    public Optional<Cliente> cliente(Long id) {
        Optional<Cliente> cliente = super.buscarPorId(id);
        if (!cliente.isPresent()) throw new CustomNotFoundException("Cliente, id: " + id + "não encontrado.");
        return cliente;
    }

    @Transactional
    public Optional<Cliente> salvar(Cliente cliente) {
        return super.salvar(cliente);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }
}
