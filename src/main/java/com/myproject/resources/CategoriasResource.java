package com.myproject.resources;

import com.myproject.domain.Categoria;
import com.myproject.services.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasResource {

    private CategoriasService categoriasService;

    @Autowired
    public CategoriasResource(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriasService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> categoria(@PathVariable("id") Long id) {
        Categoria categoria = categoriasService.categoria(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PostMapping()
    public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria) {
        categoria = categoriasService.salvar(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        categoriasService.atualizar(categoria);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        categoriasService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
