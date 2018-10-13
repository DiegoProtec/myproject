package com.myproject.resources;

import com.myproject.domains.Cliente;
import com.myproject.domains.Usuario;
import com.myproject.domains.UsuarioCliente;
import com.myproject.dtos.UsuarioClienteDTO;
import com.myproject.mappers.*;
import com.myproject.services.ClienteService;
import com.myproject.services.FuncionarioService;
import com.myproject.services.UsuariosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {

    private final UsuarioClienteMapper usuarioClienteMapper;
    private final UsuarioFuncionarioMapper usuarioFuncionarioMapper;

    private final UsuariosService usuariosService;
    private final UsuarioMapper usuarioMapper;
    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;
    private final FuncionarioService funcionarioService;
    private final FuncionarioMapper funcionarioMapper;

    public UsuariosResource(UsuarioClienteMapper usuarioClienteMapper, UsuarioFuncionarioMapper usuarioFuncionarioMapper, UsuarioMapper usuarioMapper, ClienteMapper clienteMapper, FuncionarioMapper funcionarioMapper, UsuariosService usuariosService, ClienteService clienteService, FuncionarioService funcionarioService) {
        this.usuarioClienteMapper = usuarioClienteMapper;
        this.usuarioFuncionarioMapper = usuarioFuncionarioMapper;
        this.usuarioMapper = usuarioMapper;
        this.clienteMapper = clienteMapper;
        this.funcionarioMapper = funcionarioMapper;
        this.usuariosService = usuariosService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Void> salvarCliente(@RequestBody @Valid UsuarioClienteDTO dto) {
        UsuarioCliente usuarioCliente = usuarioClienteMapper.toEntity(dto);
        Usuario usuario = usuarioCliente.getUsuario();
        Cliente cliente = usuarioCliente.getCliente();
        Optional<Usuario> usuarioOptional = usuariosService.salvar(usuario);
        cliente.setUsuario(usuarioOptional.get());
        Optional<Cliente> clienteOptional = clienteService.salvar(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(clienteOptional.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

//    @PostMapping("/funcionarios")
//    public ResponseEntity<Void> salvarFuncionario(@RequestBody @ModelAttribute("dto") UsuarioFuncionarioDTO dto) {
//        UsuarioFuncionario usuarioFuncionario = usuarioFuncionarioMapper.toEntity(dto);
//        Usuario usuario = usuarioFuncionario.getUsuario();
//        Funcionario funcionario = usuarioFuncionario.getFuncionario();
//        Optional<Usuario> usuarioOptional = usuariosService.salvar(usuario);
//        funcionario.setUsuario(usuarioOptional.get());
//        Optional<Funcionario> funcionarioOptional = funcionarioService.salvar(funcionario);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(funcionarioOptional.get().getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

//
//    @GetMapping
//    public ResponseEntity<List<Usuario>> usuarios() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.usuarios());
//    }
//
//    @GetMapping("/clientes")
//    public ResponseEntity<List<Cliente>> clientes() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.clientes());
//    }
//
//    @GetMapping("/funcionarios")
//    public ResponseEntity<List<Funcionario>> funcionarios() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.funcionarios());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> usuario(@PathVariable("id") Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.usuario(id));
//    }
//
//    @GetMapping("/clientes/{id}")
//    public ResponseEntity<Cliente> cliente(@PathVariable("id") Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.cliente(id));
//    }
//
//    @GetMapping("/funcionarios/{id}")
//    public ResponseEntity<Funcionario> funcionario(@PathVariable("id") Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(this.usuariosService.funcionario(id));
//    }
//
//    @PostMapping("/funcionarios")
//    public ResponseEntity<Void> salvarFuncionario(@Valid @RequestBody UsuarioFuncionario usuarioFuncionario) {
//        Funcionario funcionario = this.usuariosService.salvar(usuarioFuncionario);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(funcionario.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

}
