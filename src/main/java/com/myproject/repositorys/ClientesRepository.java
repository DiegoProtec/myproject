package com.myproject.repositorys;

import com.myproject.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long> {
}
