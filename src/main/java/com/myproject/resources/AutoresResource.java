package com.myproject.resources;

import com.myproject.domain.Autor;
import com.myproject.services.AutoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutoresResource {

    private AutoresServices autoresServices;

    @Autowired
    public AutoresResource(AutoresServices autoresServices) {
        this.autoresServices = autoresServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Autor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresServices.listar());
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Autor> autor(@PathVariable("id") Long id){
        Autor autor = autoresServices.autor(id);
        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Autor> salvar(@RequestBody @Valid Autor autor){
        autor = autoresServices.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Autor> atualizar(@PathVariable("id") Long id, @RequestBody Autor autor){
        autor.setId(id);
        autoresServices.atualizar(autor);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Autor> deletar(@PathVariable("id") Long id){
        autoresServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
