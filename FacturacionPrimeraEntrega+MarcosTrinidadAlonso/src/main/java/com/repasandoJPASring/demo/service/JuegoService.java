package com.repasandoJPASring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import DTO.JuegoDTO;
import DTO.JuegoMapper;
import com.repasandoJPASring.demo.model.Categoria;
import com.repasandoJPASring.demo.model.Juego;
import com.repasandoJPASring.demo.repository.CategoriaRepository;
import com.repasandoJPASring.demo.repository.juegoRepository;
import com.repasandoJPASring.demo.repository.StockRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JuegoService {

    @Autowired
    private juegoRepository juegoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private StockRepository stockRepository;


    public List<JuegoDTO> listarJuegos() {
        return juegoRepository.findAll().stream().map(JuegoMapper::toDTO).toList();
    }

    public JuegoDTO obtenerPorId(Long id) {
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        return JuegoMapper.toDTO(juego);
    }

    public JuegoDTO crearJuego(JuegoDTO juegoDTO) {
        List<Categoria> categorias = categoriaRepository.findAll().stream()
                .filter(cat -> juegoDTO.getCategorias().contains(cat.getNombre()))
                .toList();

        Juego juego = Juego.builder()
                .nombre(juegoDTO.getNombre())
                .precio(juegoDTO.getPrecio())
                .categorias(categorias)
                .fechaCreacion(LocalDate.now()) 
                .build();

        return JuegoMapper.toDTO(juegoRepository.save(juego));
    }

    public JuegoDTO actualizarJuego(Long id, JuegoDTO juegoDTO) {
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Juego con ID " + id + " no encontrado"));
    
        List<Categoria> categorias = categoriaRepository.findAll().stream()
                .filter(cat -> juegoDTO.getCategorias().stream()
                        .anyMatch(categoriaDTO -> categoriaDTO.equals(cat.getNombre())))  
                .collect(Collectors.toList());
    
        if (categorias.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron categorías válidas");
        }
    
        juego.setNombre(juegoDTO.getNombre());
        juego.setPrecio(juegoDTO.getPrecio());
        juego.setCategorias(categorias);
        juego.setFechaUpdate(LocalDate.now());
    
        return JuegoMapper.toDTO(juegoRepository.save(juego));
    }
    

    @Transactional
    public void eliminarJuego(Long id) {
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        juego.setFechaDelete(LocalDate.now());
        juegoRepository.save(juego);
        System.out.println("Juego marcado como eliminado");
    }

}
