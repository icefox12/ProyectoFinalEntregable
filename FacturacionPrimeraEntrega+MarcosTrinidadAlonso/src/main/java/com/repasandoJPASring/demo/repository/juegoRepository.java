package com.repasandoJPASring.demo.repository;

import com.repasandoJPASring.demo.model.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface juegoRepository extends JpaRepository<Juego, Long> {

    @Query("SELECT j FROM Juego j WHERE j.fechaDelete IS NULL")
    List<Juego> findAll();

    @Query("SELECT j FROM Juego j WHERE j.id = :id AND j.fechaDelete IS NULL")
    Optional<Juego> findById(Long id);

    Juego findByNombre(String nombre);

}
