package com.myproject.resources;

import com.myproject.domain.Autor;
import com.myproject.domain.Categoria;
import com.myproject.domain.Livro;
import com.myproject.services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

    private LivrosService livrosService;

    @Autowired
    public LivrosResource(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @GetMapping()
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(this.livrosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> livro(@PathVariable("id") Long id) {
        Livro livro = this.livrosService.livro(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody @Valid Livro livro) {
        livro = this.livrosService.salvar(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
        livro.setId(id);
        this.livrosService.atualizar(livro);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/autores")
    public ResponseEntity<Void> atualizarAutores(@PathVariable("id") Long id, @RequestBody Set<Autor> autores) {
        Livro livro = this.livrosService.livro(id);
        this.livrosService.atualizarAutores(livro, autores);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/categorias")
    public ResponseEntity<Void> atualizarCategorias(@PathVariable("id") Long id, @RequestBody Set<Categoria> categorias) {
        Livro livro = this.livrosService.livro(id);
        this.livrosService.atualizarCategorias(livro, categorias);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        this.livrosService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
