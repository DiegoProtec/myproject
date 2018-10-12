package com.myproject.repositorys;

import com.myproject.domains.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
