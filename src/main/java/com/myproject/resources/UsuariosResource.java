package com.myproject.resources;

import com.myproject.domain.*;
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
    public ResponseEntity<List<Usuario>> usuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.usuarios());
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> clientes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.clientes());
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> funcionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.funcionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> usuario(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.usuario(id));
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> cliente(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.cliente(id));
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> funcionario(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.funcionario(id));
    }

    @PostMapping("/clientes")
    public ResponseEntity<Void> salvarCliente(@RequestBody @Valid UsuarioCliente usuarioCliente) {
        Cliente cliente = this.usuariosService.salvar(usuarioCliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Void> salvarFuncionario(@RequestBody @Valid UsuarioFuncionario usuarioFuncionario) {
        Funcionario funcionario = this.usuariosService.salvar(usuarioFuncionario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(funcionario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
