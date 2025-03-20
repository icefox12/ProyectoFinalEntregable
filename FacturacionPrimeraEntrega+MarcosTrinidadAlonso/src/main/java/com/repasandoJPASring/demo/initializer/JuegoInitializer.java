package com.repasandoJPASring.demo.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.repasandoJPASring.demo.model.Categoria;
import com.repasandoJPASring.demo.model.Juego;
import com.repasandoJPASring.demo.repository.CategoriaRepository;
import com.repasandoJPASring.demo.repository.juegoRepository;
import java.time.LocalDate;
import java.util.List;

@Component
public class JuegoInitializer {

@Autowired
private juegoRepository juegoRepository;

@Autowired
private CategoriaRepository categoriaRepository;

    public void initialize() {
        Categoria accion = new Categoria("Acción");
        Categoria aventura = new Categoria("Aventura");
        Categoria rpg = new Categoria("RPG");
        Categoria deportes = new Categoria("Deportes");
        Categoria estrategia = new Categoria("Estrategia");
        Categoria simulacion = new Categoria("Simulación");

        categoriaRepository.saveAll(List.of(accion, aventura, rpg, deportes, estrategia, simulacion));

        Juego juego1 = Juego.builder()
                .nombre("Hades II")
                .fechaCreacion(LocalDate.of(2020, 11, 10))
                .precio(49.99)
                .categorias(List.of(accion, aventura))
                .build();

        Juego juego2 = Juego.builder()
                .nombre("Half-Life 2")
                .fechaCreacion(LocalDate.of(2015, 5, 19))
                .precio(39.99)
                .categorias(List.of(rpg, aventura))
                .build();

        Juego juego3 = Juego.builder()
                .nombre("EA FC 25")
                .fechaCreacion(LocalDate.of(2024, 9, 27))
                .precio(59.99)
                .categorias(List.of(deportes))
                .build();

        Juego juego4 = Juego.builder()
                .nombre("Dark Souls III")
                .fechaCreacion(LocalDate.of(2016, 4, 12))
                .precio(34.99)
                .categorias(List.of(rpg, accion))
                .build();

        Juego juego5 = Juego.builder()
                .nombre("The Legend of Zelda: Breath of the Wild")
                .fechaCreacion(LocalDate.of(2017, 3, 3))
                .precio(54.99)
                .categorias(List.of(aventura))
                .build();

        Juego juego6 = Juego.builder()
                .nombre("League of Legends")
                .fechaCreacion(LocalDate.of(2009, 10, 27))
                .precio(0.99)
                .categorias(List.of(rpg, accion))
                .build();

        Juego juego7 = Juego.builder()
                .nombre("Minecraft")
                .fechaCreacion(LocalDate.of(2011, 11, 18))
                .precio(26.95)
                .categorias(List.of(aventura, simulacion))
                .build();

        Juego juego8 = Juego.builder()
                .nombre("Civilization VI")
                .fechaCreacion(LocalDate.of(2016, 10, 21))
                .precio(29.99)
                .categorias(List.of(estrategia, simulacion))
                .build();

        Juego juego9 = Juego.builder()
                .nombre("Overwatch")
                .fechaCreacion(LocalDate.of(2016, 5, 24))
                .precio(39.99)
                .categorias(List.of(accion, deportes))
                .build();

        Juego juego10 = Juego.builder()
                .nombre("Red Dead Redemption 2")
                .fechaCreacion(LocalDate.of(2018, 10, 26))
                .precio(59.99)
                .categorias(List.of(aventura, accion))
                .build();

        Juego juego11 = Juego.builder()
                .nombre("Fortnite")
                .fechaCreacion(LocalDate.of(2017, 7, 25))
                .precio(0.00)
                .categorias(List.of(accion, aventura))
                .build();

        Juego juego12 = Juego.builder()
                .nombre("Starcraft II")
                .fechaCreacion(LocalDate.of(2010, 7, 27))
                .precio(19.99)
                .categorias(List.of(estrategia))
                .build();

        juegoRepository.saveAll(List.of(juego1, juego2, juego3, juego4, juego5, juego6, juego7, juego8, juego9, juego10, juego11, juego12));
    }
}