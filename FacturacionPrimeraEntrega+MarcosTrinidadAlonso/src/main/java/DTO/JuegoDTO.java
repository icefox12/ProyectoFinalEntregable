package DTO;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JuegoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private List<String> categorias;
    
}
