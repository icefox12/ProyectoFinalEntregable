package com.repasandoJPASring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.repasandoJPASring.demo.model.Facturacion;
import com.repasandoJPASring.demo.service.ComprobanteService;

@RestController
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping("/comprobantes")
    public ResponseEntity<?> createComprobante(@RequestBody Facturacion request) {
        comprobanteService.createComprobante(request);
        return ResponseEntity.ok().build();
    }
}