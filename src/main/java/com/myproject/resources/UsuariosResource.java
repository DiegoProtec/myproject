package com.myproject.resources;

import com.myproject.domain.Usuario;
import com.myproject.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {

    private UsuariosService usuariosService;

    @Autowired
    public UsuariosResource(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuario(@PathVariable("id") Long id){
        Usuario usuario = this.usuariosService.usuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid Usuario usuario) {
        this.usuariosService.salvar(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        usuario.setId(id);
        this.usuariosService.atualizar(usuario);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        this.usuariosService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
