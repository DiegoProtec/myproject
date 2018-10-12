package com.myproject.repositorys;

import com.myproject.domains.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
}
