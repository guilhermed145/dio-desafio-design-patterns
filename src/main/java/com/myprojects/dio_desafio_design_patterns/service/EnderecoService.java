package com.myprojects.dio_desafio_design_patterns.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myprojects.dio_desafio_design_patterns.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface EnderecoService {

    @GetMapping(value = "/{cep}/json")
    Endereco getEndereco(@PathVariable("cep") String cep);

}
