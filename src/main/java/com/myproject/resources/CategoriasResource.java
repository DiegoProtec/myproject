package com.myproject.resources;

import com.myproject.domain.Categoria;
import com.myproject.repositorys.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasResource {

    private CategoriasRepository categoriasRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar(){
        return (List<Categoria>) categoriasRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Categoria categoria){
        categoriasRepository.save(categoria);
    }
}
