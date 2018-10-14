package com.myproject.resources;

import com.myproject.domains.*;
import com.myproject.dtos.UsuarioClienteDTO;
import com.myproject.dtos.UsuarioFuncionarioDTO;
import com.myproject.mappers.UsuarioClienteMapper;
import com.myproject.mappers.UsuarioFuncionarioMapper;
import com.myproject.services.ClienteService;
import com.myproject.services.FuncionarioService;
import com.myproject.services.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResource {

    private final UsuarioClienteMapper usuarioClienteMapper;
    private final UsuarioFuncionarioMapper usuarioFuncionarioMapper;
    private final UsuariosService usuariosService;
    private final ClienteService clienteService;
    private final FuncionarioService funcionarioService;

    public UsuariosResource(UsuarioClienteMapper usuarioClienteMapper, UsuarioFuncionarioMapper usuarioFuncionarioMapper, UsuariosService usuariosService, ClienteService clienteService, FuncionarioService funcionarioService) {
        this.usuarioClienteMapper = usuarioClienteMapper;
        this.usuarioFuncionarioMapper = usuarioFuncionarioMapper;
        this.usuariosService = usuariosService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Void> salvarCliente(@RequestBody @Valid UsuarioClienteDTO dto) {
        return this.salvarCliente(usuarioClienteMapper.toEntity(dto));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Void> salvarCliente(@PathVariable("id") Long id, @RequestBody @Valid UsuarioClienteDTO dto) {
        UsuarioCliente usuarioCliente = usuarioClienteMapper.toEntity(dto);
        usuarioCliente.getUsuario().setId(id);
        usuarioCliente.getCliente().setId(usuarioCliente.getUsuario().getId());
        return this.salvarCliente(usuarioCliente);
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Void> salvarFuncionario(@RequestBody @Valid UsuarioFuncionarioDTO dto) {
        return this.salvarFuncionario(usuarioFuncionarioMapper.toEntity(dto));
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Void> salvarFucionario(@PathVariable("id") Long id, @RequestBody @Valid UsuarioFuncionarioDTO dto) {
        UsuarioFuncionario usuarioFuncionario = usuarioFuncionarioMapper.toEntity(dto);
        usuarioFuncionario.getUsuario().setId(id);
        usuarioFuncionario.getFuncionario().setId(usuarioFuncionario.getUsuario().getId());
        return this.salvarFuncionario(usuarioFuncionario);
    }


    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> clientes() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.clienteService.listar()
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<Funcionario>> funcionarios() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.funcionarioService.listar()
                        .collect(Collectors.toList())
        );
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> usuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.usuariosService.listar()
                        .collect(Collectors.toList())
        );
    }

    private ResponseEntity<Void> salvarCliente(UsuarioCliente usuarioCliente) {
        Usuario usuario = usuarioCliente.getUsuario();
        Cliente cliente = usuarioCliente.getCliente();
        usuario = usuariosService.salvar(usuario);
        cliente.setUsuario(usuario);
        Optional<Cliente> op = Optional.of(clienteService.salvar(cliente));
        if (!op.isPresent()) throw new RuntimeException();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(op.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    private ResponseEntity<Void> salvarFuncionario(UsuarioFuncionario usuarioFuncionario) {
        Usuario usuario = usuarioFuncionario.getUsuario();
        Funcionario funcionario = usuarioFuncionario.getFuncionario();
        usuario = usuariosService.salvar(usuario);
        funcionario.setUsuario(usuario);
        Optional<Funcionario> op = Optional.of(funcionarioService.salvar(funcionario));
        if (!op.isPresent()) throw new RuntimeException();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(op.get().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
