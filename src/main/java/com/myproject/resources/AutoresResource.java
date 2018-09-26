package com.myproject.resources;

import com.myproject.domain.Autor;
import com.myproject.repositorys.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutoresResource {

    private AutoresRepository autoresRepository;

    @Autowired
    public AutoresResource(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void salvar(@RequestBody Autor autor){
        autoresRepository.save(autor);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Autor getAutor(@PathVariable("id") Long id){
        Optional<Autor> op = autoresRepository.findById(id);
        if(op.isPresent()) {
            return op.get();
        } else return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable("id") Long id){
        Optional<Autor> op = autoresRepository.findById(id);
        if(op.isPresent()) autoresRepository.delete(op.get());
    }
}
