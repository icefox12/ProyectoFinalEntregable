package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.repasandoJPASring.demo.model.Cliente;
import com.repasandoJPASring.demo.service.ClienteService;

@Component
public class ClienteInitializer {

    @Autowired
    private ClienteService clienteService;

    public void initialize() {
        Cliente c1 = new Cliente();
        c1.setNombre("Carlos");
        c1.setApellido("Perez");
        c1.setEdad(30);
        c1.setDni(22345678L);

        Cliente c2 = new Cliente();
        c2.setNombre("Ana");
        c2.setApellido("Lopez");
        c2.setEdad(28);
        c2.setDni(22345679L);

        Cliente c3 = new Cliente();
        c3.setNombre("Luis");
        c3.setApellido("Martinez");
        c3.setEdad(35);
        c3.setDni(22345680L);

        clienteService.save(c1);
        clienteService.save(c2);
        clienteService.save(c3);
    }
}
