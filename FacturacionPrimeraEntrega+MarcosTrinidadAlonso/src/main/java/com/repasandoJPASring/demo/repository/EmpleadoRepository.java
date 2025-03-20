package com.repasandoJPASring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repasandoJPASring.demo.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findBySucursalId(Long sucursalId);
    Empleado getByDni(long dni);
}
