package com.repasandoJPASring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import DTO.JuegoDTO;
import jakarta.transaction.Transactional;

import com.repasandoJPASring.demo.model.ApiResponse;
import com.repasandoJPASring.demo.service.JuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @GetMapping
    public ResponseEntity<List<JuegoDTO>> listar() {
        return ResponseEntity.ok().body(juegoService.listarJuegos());
    }

    @GetMapping("/juegos/{id}")
    public ResponseEntity<JuegoDTO> listar(@PathVariable Long id) {
        return ResponseEntity.ok().body(juegoService.obtenerPorId(id));
    }

    @GetMapping("/apiResponse")
    public ResponseEntity<?> listarApiResponse() {
        List<JuegoDTO> juegos = juegoService.listarJuegos();
        return ResponseEntity.ok().body(new ApiResponse("OK", juegos, "Sin errores"));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable Long id, @RequestBody JuegoDTO juegoDTO) {
        try {
            JuegoDTO juegoActualizado = juegoService.actualizarJuego(id, juegoDTO);
            return ResponseEntity.ok().body(new ApiResponse("OK", juegoActualizado, "Sin errores"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse("Datos inválidos", null, e.getMessage()));
        }
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            juegoService.eliminarJuego(id);
            return ResponseEntity.ok().body(new ApiResponse("OK", null, "Juego eliminado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse("Error", null, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody JuegoDTO juegoDTO) {
        try {
            JuegoDTO nuevoJuego = juegoService.crearJuego(juegoDTO);
            return ResponseEntity.ok().body(new ApiResponse("OK", nuevoJuego, "Juego creado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse("Error", null, e.getMessage()));
        }
    }
}
