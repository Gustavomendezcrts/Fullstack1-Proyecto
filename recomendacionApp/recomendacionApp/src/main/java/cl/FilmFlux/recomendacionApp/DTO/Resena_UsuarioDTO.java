package cl.FilmFlux.recomendacionApp.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resena_UsuarioDTO {
    private int puntaje;
    private String comentario;
    private String nombre_usuario;
}
