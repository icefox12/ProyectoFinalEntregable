package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repasandoJPASring.demo.model.Categoria;
import com.repasandoJPASring.demo.repository.CategoriaRepository;

@Component
public class CategoriaInitializer {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void initialize() {
        Categoria categoriaUno = new Categoria("Acción");
        Categoria categoriaDos = new Categoria("Aventura");
        Categoria categoriaTres = new Categoria("Deportes");
        Categoria categoriaCuatro = new Categoria("Estrategia");
        Categoria categoriaCinco = new Categoria("Simulación");

        categoriaRepository.save(categoriaUno);
        categoriaRepository.save(categoriaDos);
        categoriaRepository.save(categoriaTres);
        categoriaRepository.save(categoriaCuatro);
        categoriaRepository.save(categoriaCinco);
    }
}
