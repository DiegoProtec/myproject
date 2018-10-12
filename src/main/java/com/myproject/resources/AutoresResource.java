package com.myproject.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutoresResource {

//    private AutorService autorService;
//
//    @Autowired
//    public AutoresResource(AutorService autorService) {
//        this.autorService = autorService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<Autor>> listar() {
//        return ResponseEntity.status(HttpStatus.OK).body(this.autorService.listar());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Autor> autor(@PathVariable("id") Long id) {
//        Autor autor = this.autorService.autor(id);
//        return ResponseEntity.status(HttpStatus.OK).body(autor);
//    }
//
//    @PostMapping()
//    public ResponseEntity<Void> salvar(@RequestBody @Valid Autor autor) {
//        autor = this.autorService.salvar(autor);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(autor.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Autor autor) {
//        autor.setId(id);
//        this.autorService.atualizar(autor);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
//        this.autorService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
