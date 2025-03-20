package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repasandoJPASring.demo.model.Stock;
import com.repasandoJPASring.demo.model.Sucursal;
import com.repasandoJPASring.demo.repository.StockRepository;
import com.repasandoJPASring.demo.repository.juegoRepository;
import com.repasandoJPASring.demo.model.Juego;

@Component
public class StockInitializer {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private juegoRepository juegoRepository;

    public void initialize(Sucursal sucursalUno, Sucursal sucursalDos, Sucursal sucursalTres) {
        Juego v1 = juegoRepository.findById(1L).orElseThrow(() -> new RuntimeException("Videojuego with ID 1 not found"));
        Juego v2 = juegoRepository.findById(2L).orElseThrow(() -> new RuntimeException("Videojuego with ID 2 not found"));

        Stock stock1 = new Stock();
        stock1.setSucursal(sucursalUno);
        stock1.setJuego(v1);
        stock1.setCantidad(10);
        stockRepository.save(stock1);

        Stock stock2 = new Stock();
        stock2.setSucursal(sucursalUno);
        stock2.setJuego(v2);
        stock2.setCantidad(5);
        stockRepository.save(stock2);

        Stock stock3 = new Stock();
        stock3.setSucursal(sucursalDos);
        stock3.setJuego(v1);
        stock3.setCantidad(8);
        stockRepository.save(stock3);

        Stock stock4 = new Stock();
        stock4.setSucursal(sucursalTres);
        stock4.setJuego(v2);
        stock4.setCantidad(12);
        stockRepository.save(stock4);
    }
}
