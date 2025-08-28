package com.myprojects.dio_desafio_design_patterns.repository;

import org.springframework.data.repository.CrudRepository;

import com.myprojects.dio_desafio_design_patterns.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {



}
