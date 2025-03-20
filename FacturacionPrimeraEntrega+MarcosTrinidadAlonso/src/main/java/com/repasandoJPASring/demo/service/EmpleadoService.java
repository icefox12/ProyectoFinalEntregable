package com.repasandoJPASring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repasandoJPASring.demo.model.Empleado;
import com.repasandoJPASring.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Optional<Empleado> findById(Long id) {
        return Optional.empty();
    }

    public Empleado getByDni(String dni) {
        long dniLong = Long.parseLong(dni);
        Empleado empleado = empleadoRepository.getByDni(dniLong);
        if (empleado != null) {
            return empleado;
        }
        throw new RuntimeException("Empleado no encontrado");
    }

    public void save(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public List<Empleado> findBySucursalId(long idSucursal) {
        return empleadoRepository.findBySucursalId(idSucursal);
    }
}
