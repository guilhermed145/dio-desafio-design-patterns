package com.myprojects.dio_desafio_design_patterns.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.dio_desafio_design_patterns.model.Cliente;
import com.myprojects.dio_desafio_design_patterns.model.Endereco;
import com.myprojects.dio_desafio_design_patterns.repository.ClienteRepository;
import com.myprojects.dio_desafio_design_patterns.repository.EnderecoRepository;
import com.myprojects.dio_desafio_design_patterns.service.ClienteService;
import com.myprojects.dio_desafio_design_patterns.service.EnderecoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        if (!clienteRepository.existsById(id)) throw new EntityNotFoundException(("Cliente não encontrado com id " + id));
        return clienteRepository.findById(id).get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        if (clienteEncontrado.isPresent()) {
            cliente.setId(id);
            salvarClienteComCep(cliente);
        } else {
            throw new EntityNotFoundException(("Cliente não encontrado com id " + id));
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cepDoCliente = cliente.getEndereco().getCep();
        Endereco enderecoDoCliente = enderecoRepository.findById(cepDoCliente).orElseGet(() -> {
            Endereco novoEndereco = enderecoService.getEndereco(cepDoCliente);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(enderecoDoCliente);
        clienteRepository.save(cliente);
    }

}
