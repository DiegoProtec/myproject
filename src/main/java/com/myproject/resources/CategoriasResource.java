package com.myproject.resources;

import com.myproject.domain.Categoria;
import com.myproject.repositorys.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Categoria> listar() {
        return categoriasRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Categoria categoria) {
        categoriasRepository.save(categoria);
        System.out.println(categoriasRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Categoria getCategoria(@PathVariable("id") Long id) {
        Optional<Categoria> op = categoriasRepository.findById(id);
        if(op.isPresent()) {
            return op.get();
        } else return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id) {
        Optional<Categoria> op = categoriasRepository.findById(id);
        if(op.isPresent()) categoriasRepository.delete(op.get());
    }

}
