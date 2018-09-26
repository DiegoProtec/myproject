package com.myproject.repositorys;

import com.myproject.domain.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends CrudRepository<Categoria, Long> {

}
