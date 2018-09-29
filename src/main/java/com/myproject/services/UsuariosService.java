package com.myproject.services;

import com.myproject.domain.Usuario;
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

    @Autowired
    public UsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar(){
        return this.usuarioRepository.findAll();
    }

    public Usuario usuario(Long id){
        Optional<Usuario> op = this.usuarioRepository.findById(id);
        if(!op.isPresent()) throw new CustomNotFoundException("id: " + id);
        return op.get();
    }

    public Usuario salvar(Usuario usuario){
        if(usuario.getId() != null){
            Optional<Usuario> op = this.usuarioRepository.findById(usuario.getId());
            if(op.isPresent()) throw new CustomExistEntity("Usuário já cadastrado.");
        }
        return this.usuarioRepository.save(usuario);
    }

    public void atualizar(Usuario usuario){
        this.existe(usuario);
        this.usuarioRepository.save(usuario);
    }

    public void deletar(Long id){
        Usuario usuario = this.usuario(id);
        this.usuarioRepository.delete(usuario);
    }

    private void existe(Usuario usuario){
        this.usuario(usuario.getId());
    }
}
