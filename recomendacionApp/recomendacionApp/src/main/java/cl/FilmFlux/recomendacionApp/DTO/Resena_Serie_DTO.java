package cl.FilmFlux.recomendacionApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resena_Serie_DTO {
    private String comentario; 
    private int puntaje; 
    private String tituloSerie;
    private String generoSerie;  
}
