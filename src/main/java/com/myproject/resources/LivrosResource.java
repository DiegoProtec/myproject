package com.myproject.resources;

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

@RestController
@RequestMapping("/livros")
public class LivrosResource {

    private LivrosService livrosService;

    @Autowired
    public LivrosResource(LivrosService livrosService) {
        this.livrosService = livrosService;
    }

    @GetMapping()
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> livro(@PathVariable("id") Long id){
        Livro livro = livrosService.livro(id);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody @Valid Livro livro){
        livro = livrosService.salvar(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro){
        livro.setId(id);
        livrosService.atualizar(livro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        livrosService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
