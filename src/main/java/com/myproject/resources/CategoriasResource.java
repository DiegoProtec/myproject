package com.myproject.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.myproject.domain.Categoria;
import com.myproject.exceptions.CategoriaException;
import com.myproject.repositorys.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriasResource {

    private CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasResource(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriasRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Categoria> salvar(@Valid  @RequestBody Categoria categoria) {
        categoria = categoriasRepository.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resource<Categoria> getCategoria(@PathVariable("id") Long id) {
        Optional<Categoria> op = categoriasRepository.findById(id);
        if (!op.isPresent()) throw new CategoriaException("id-" + id);
        Resource<Categoria> resource = new Resource<>(op.get());
        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).listar());
        resource.add(link.withRel("categorias"));
        return resource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> atualizar(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> op = categoriasRepository.findById(id);
        if (!op.isPresent()) return ResponseEntity.notFound().build();
        categoria.setId(id);
        categoriasRepository.save(categoria);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        try {
            categoriasRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
