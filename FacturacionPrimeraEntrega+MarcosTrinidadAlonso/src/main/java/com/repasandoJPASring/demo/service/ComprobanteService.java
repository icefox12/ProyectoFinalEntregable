package com.repasandoJPASring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repasandoJPASring.demo.model.Cliente;
import com.repasandoJPASring.demo.model.Facturacion;
import com.repasandoJPASring.demo.model.Juego;
import com.repasandoJPASring.demo.repository.ClienteRepository;
import com.repasandoJPASring.demo.repository.juegoRepository;

@Service
public class ComprobanteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private juegoRepository juegoRepository;

    public void createComprobante(Facturacion request) {
        // Lógica para crear el comprobante usando los datos del request
        Cliente cliente = clienteRepository.findById(request.getCliente().getClienteid())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        for (Facturacion.Linea linea : request.getLineas()) {
            Juego juego = juegoRepository.findById(linea.getProducto().getProductoid())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            // Lógica adicional para procesar cada línea
        }
    }
}
