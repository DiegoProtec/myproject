package com.myproject.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

//    private LivroService livroService;
//
//    @Autowired
//    public LivrosResource(LivroService livroService) {
//        this.livroService = livroService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<Livro>> listar() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.livroService.listar());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Livro> livro(@PathVariable("id") Long id) {
//        Livro livro = this.livroService.livro(id);
//        return ResponseEntity.status(HttpStatus.OK).body(livro);
//    }
//
//    @PostMapping()
//    public ResponseEntity<Void> salvar(@RequestBody @Valid Livro livro) {
//        livro = this.livroService.salvar(livro);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(livro.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
//        livro.setId(id);
//        this.livroService.atualizar(livro);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}/autores")
//    public ResponseEntity<Void> atualizarAutores(@PathVariable("id") Long id, @RequestBody Set<Autor> autores) {
//        Livro livro = this.livroService.livro(id);
//        this.livroService.atualizarAutores(livro, autores);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}/categorias")
//    public ResponseEntity<Void> atualizarCategorias(@PathVariable("id") Long id, @RequestBody Set<Categoria> categorias) {
//        Livro livro = this.livroService.livro(id);
//        this.livroService.atualizarCategorias(livro, categorias);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
//        this.livroService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }

}
