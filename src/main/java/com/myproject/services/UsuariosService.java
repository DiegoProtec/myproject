package com.myproject.services;

import com.myproject.domains.Usuario;
import com.myproject.repositorys.UsuarioRepository;
import com.myproject.resources.exceptions.CustomNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuariosService extends AbstractCrudService<Usuario, Long, UsuarioRepository> {

    public UsuariosService(UsuarioRepository repository) {
        super(repository);
    }

    public Usuario usuario(Long id) {
        Optional<Usuario> usuario = Optional.of(super.buscarPorId(id));
        if (!usuario.isPresent()) throw new CustomNotFoundException("Usuário, id: " + id + ", não encontrado.");
        return usuario.get();
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return super.salvar(usuario);
    }

    @Transactional
    public void deletar(Long id) {
        super.deletar(id);
    }

}
