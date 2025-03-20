package com.repasandoJPASring.demo.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "juegos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String nombre;
    private Double precio;

    // Fechas de creacion, actualizacion y eliminacion

    private LocalDate fechaCreacion;
    private LocalDate fechaUpdate;
    private LocalDate fechaDelete;

    @ManyToMany
    @JoinTable(name = "juego_categoria", joinColumns = @JoinColumn(name = "juego_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;
}
