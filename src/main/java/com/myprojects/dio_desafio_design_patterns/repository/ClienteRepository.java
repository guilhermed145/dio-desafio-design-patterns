package com.myprojects.dio_desafio_design_patterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.myprojects.dio_desafio_design_patterns.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
