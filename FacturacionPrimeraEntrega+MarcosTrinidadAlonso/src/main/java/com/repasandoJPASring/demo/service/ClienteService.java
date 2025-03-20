package com.repasandoJPASring.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repasandoJPASring.demo.model.Cliente;
import com.repasandoJPASring.demo.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findByNombre(String nombre) {
        return ClienteRepository.findByNombre(nombre);
    }

    public Cliente findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}
