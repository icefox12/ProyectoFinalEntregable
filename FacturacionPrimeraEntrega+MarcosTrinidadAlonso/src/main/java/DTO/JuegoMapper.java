package DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.repasandoJPASring.demo.model.Categoria;
import com.repasandoJPASring.demo.model.Juego;
import com.repasandoJPASring.demo.repository.CategoriaRepository;

@Component
public class JuegoMapper {

public static JuegoDTO toDTO(Juego juego) {
        if (juego == null) {
        return null;
        }

        return JuegoDTO.builder()
                .id(juego.getId())
                .nombre(juego.getNombre())
                .precio(juego.getPrecio())
                .categorias(juego.getCategorias() != null
                        ? juego.getCategorias().stream().map(Categoria::getNombre).toList()
                        : List.of())  
                .build();
}

public static Juego toEntity(JuegoDTO juegoDTO, CategoriaRepository categoriaRepository) {
        return Juego.builder()
                .id(juegoDTO.getId())
                .nombre(juegoDTO.getNombre())
                .precio(juegoDTO.getPrecio())
                .categorias(juegoDTO.getCategorias() != null
                        ? categoriaRepository.findAll().stream()
                                .filter(cat -> juegoDTO.getCategorias().contains(cat.getNombre()))
                                .toList()
                        : List.of())
                .build();
}

}
