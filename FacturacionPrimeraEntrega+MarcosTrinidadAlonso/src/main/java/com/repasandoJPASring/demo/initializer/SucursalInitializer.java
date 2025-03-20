package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repasandoJPASring.demo.model.Sucursal;
import com.repasandoJPASring.demo.model.Stock;
import com.repasandoJPASring.demo.repository.StockRepository;
import com.repasandoJPASring.demo.service.SucursalService;

import java.util.List;

@Component
public class SucursalInitializer {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private StockRepository stockRepository;

    //
    // LISTA DE SUCURSALES :
    //

    public Sucursal initializeSucursalUno() {
        Sucursal sucursalUno = new Sucursal();
        sucursalUno.setNombre("Sucursal Centro");
        sucursalUno.setUbicacion("Centro de la ciudad");
        sucursalService.save(sucursalUno);

        List<Stock> stock = stockRepository.findBySucursal(sucursalUno);
        sucursalUno.setStock(stock);

        return sucursalUno;
    }

    public Sucursal initializeSucursalDos() {
        Sucursal sucursalDos = new Sucursal();
        sucursalDos.setNombre("Sucursal Norte");
        sucursalDos.setUbicacion("Zona norte");
        sucursalService.save(sucursalDos);

        List<Stock> stock = stockRepository.findBySucursal(sucursalDos);
        sucursalDos.setStock(stock);

        return sucursalDos;
    }

    public Sucursal initializeSucursalTres() {
        Sucursal sucursalTres = new Sucursal();
        sucursalTres.setNombre("Sucursal Sur");
        sucursalTres.setUbicacion("Zona sur");
        sucursalService.save(sucursalTres);

        List<Stock> stock = stockRepository.findBySucursal(sucursalTres);
        sucursalTres.setStock(stock);

        return sucursalTres;
    }
}
