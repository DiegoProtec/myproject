package com.myproject.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasResource {

//    private CategoriaService categoriaService;
//
//    @Autowired
//    public CategoriasResource(CategoriaService categoriaService) {
//        this.categoriaService = categoriaService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<Categoria>> listar() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.listar());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Categoria> categoria(@PathVariable("id") Long id) {
//        Categoria categoria = this.categoriaService.categoria(id);
//        return ResponseEntity.status(HttpStatus.OK).body(categoria);
//    }
//
//    @PostMapping()
//    public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria) {
//        categoria = this.categoriaService.salvar(categoria);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(categoria.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
//        categoria.setId(id);
//        this.categoriaService.atualizar(categoria);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
//        this.categoriaService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }

}
