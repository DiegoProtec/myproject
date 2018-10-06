package com.myproject.repositorys;

import com.myproject.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionario, Long> {
}
