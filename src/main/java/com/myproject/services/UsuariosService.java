package com.myproject.services;

import com.myproject.domain.*;
import com.myproject.repositorys.ClientesRepository;
import com.myproject.repositorys.FuncionariosRepository;
import com.myproject.repositorys.UsuarioRepository;
import com.myproject.resources.exceptions.CustomExistEntity;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Usuario> listar() {
        return this.usuarioRepository.findAll();
    }

    public Usuario usuario(Long id) {
        Optional<Usuario> op = this.usuarioRepository.findById(id);
        if (!op.isPresent()) throw new CustomNotFoundException("id: " + id);
        return op.get();
    }

    public Cliente salvar(UsuarioCliente usuarioCliente) {
        Usuario usuario = usuarioCliente.getUsuario();
        if (usuario.getId() != null) throw new CustomExistEntity("Usuário já cadastrado.");
        usuario = this.usuarioRepository.save(usuario);
        Cliente cliente = new Cliente(usuarioCliente.getCliente().getTelefone(), usuario);
        if (cliente.getId() != null) throw new CustomExistEntity("Cliente já cadastrado.");
        return this.clientesRepository.save(cliente);
    }

    public Funcionario salvar(UsuarioFuncionario usuarioFuncionario) {
        Usuario usuario = usuarioFuncionario.getUsuario();
        if (usuario.getId() != null) throw new CustomExistEntity("Usuário já cadastrado.");
        usuario = this.usuarioRepository.save(usuario);
        Funcionario funcionario = new Funcionario(usuarioFuncionario.getUsuario());
        if (funcionario.getId() != null) throw new CustomExistEntity("Funcionário já cadastrado.");
        return this.funcionariosRepository.save(funcionario);
    }
}
