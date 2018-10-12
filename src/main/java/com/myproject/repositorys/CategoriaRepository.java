package com.myproject.repositorys;

import com.myproject.domains.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
