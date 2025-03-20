package com.repasandoJPASring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repasandoJPASring.demo.model.Sucursal;
import com.repasandoJPASring.demo.repository.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
}
