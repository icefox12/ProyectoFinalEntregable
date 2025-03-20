package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repasandoJPASring.demo.model.Empleado;
import com.repasandoJPASring.demo.model.Sucursal;
import com.repasandoJPASring.demo.service.EmpleadoService;

@Component
public class EmpleadoInitializer {

    @Autowired
    private EmpleadoService empleadoService;

    public void initialize(Sucursal sucursalUno, Sucursal sucursalDos, Sucursal sucursalTres) {
        Empleado e1 = new Empleado();
        e1.setNombre("Juan");
        e1.setApellido("Verstappen");
        e1.setEdad(20);
        e1.setDni(12345678L);
        e1.setSucursal(sucursalUno);

        Empleado e2 = new Empleado();
        e2.setNombre("Maria");
        e2.setApellido("Gomez");
        e2.setEdad(25);
        e2.setDni(12345671L);
        e2.setSucursal(sucursalUno);

        Empleado e3 = new Empleado();
        e3.setNombre("Gonzalo");
        e3.setApellido("Valdez");
        e3.setEdad(33);
        e3.setDni(12345672L);
        e3.setSucursal(sucursalTres);

        Empleado e4 = new Empleado();
        e4.setNombre("Marcos");
        e4.setApellido("Trinidad");
        e4.setEdad(22);
        e4.setDni(12345673L);
        e4.setSucursal(sucursalDos);

        empleadoService.save(e1);
        empleadoService.save(e2);
        empleadoService.save(e3);
        empleadoService.save(e4);
    }
}
