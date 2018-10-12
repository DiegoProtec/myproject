package com.myproject.services;

import com.myproject.domains.*;
import com.myproject.repositorys.ClientesRepository;
import com.myproject.repositorys.FuncionariosRepository;
import com.myproject.repositorys.UsuarioRepository;
import com.myproject.resources.exceptions.CustomExistEntityException;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private UsuarioRepository usuarioRepository;
    private ClientesRepository clientesRepository;
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    public UsuariosService(UsuarioRepository usuarioRepository, ClientesRepository clientesRepository, FuncionariosRepository funcionariosRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clientesRepository = clientesRepository;
        this.funcionariosRepository = funcionariosRepository;
    }

    public List<Usuario> usuarios() { return this.usuarioRepository.findAll(); }

    public List<Cliente> clientes() {
        return this.clientesRepository.findAll();
    }

    public List<Funcionario> funcionarios() {
        return this.funcionariosRepository.findAll();
    }

    public Usuario usuario(Long id) {
        Optional<Usuario> op = this.usuarioRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("Usuário, id: " + id + ", não encontrado.");
        return op.get();
    }

    public Cliente cliente(Long id) {
        Optional<Cliente> op = this.clientesRepository.findById(id);
        if(!op.isPresent()) throw new CustomNotFoundException("Cliente, id: " + id + ", não encontrado.");
        return op.get();
    }

    public Funcionario funcionario(Long id) {
        Optional<Funcionario> op = this.funcionariosRepository.findById(id);
        if(!op.isPresent()) throw new CustomNotFoundException("Funcionário, id: " + id + ", não encontrado.");
        return op.get();
    }

    @Transactional
    public Cliente salvar(UsuarioCliente usuarioCliente) {
        Usuario usuario = usuarioCliente.getUsuario();
        if (usuario.getId() != null) {
            Optional<Usuario> op = this.usuarioRepository.findById(usuario.getId());
            if(op.isPresent()) throw new CustomExistEntityException("Usuário já cadastrado.");
        }
        usuario = this.usuarioRepository.save(usuario);
        Cliente cliente = new Cliente(usuarioCliente.getCliente().getTelefone(), usuario);
        if (cliente.getId() != null) {
            Optional<Cliente> op = this.clientesRepository.findById(cliente.getId());
            if (op.isPresent()) throw new CustomExistEntityException("Cliente já cadastrado.");
        }
        return this.clientesRepository.save(cliente);
    }

    @Transactional
    public Funcionario salvar(UsuarioFuncionario usuarioFuncionario) {
        Usuario usuario = usuarioFuncionario.getUsuario();
        if (usuario.getId() != null) {
            Optional<Usuario> op = this.usuarioRepository.findById(usuario.getId());
            if(op.isPresent()) throw new CustomExistEntityException("Usuário já cadastrado.");
        }
        usuario = this.usuarioRepository.save(usuario);
        Funcionario funcionario = new Funcionario(usuario);
        if (funcionario.getId() != null) {
            Optional<Funcionario> op = this.funcionariosRepository.findById(funcionario.getId());
            if (op.isPresent()) throw new CustomExistEntityException("Funcionário já cadastrado.");
        }
        return this.funcionariosRepository.save(funcionario);
    }
}
