package com.repasandoJPASring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.repasandoJPASring.demo.repository.StockRepository;
import com.repasandoJPASring.demo.repository.SucursalRepository;

@Controller
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/stock")
    public String getStock(Model model) {
        // Pasa la lista de sucursales y su stock al modelo
        model.addAttribute("sucursales", sucursalRepository.findAll());
        // Pasa la lista de stock al modelo
        model.addAttribute("stocks", stockRepository.findAll());
        return "stock";
    }
}
