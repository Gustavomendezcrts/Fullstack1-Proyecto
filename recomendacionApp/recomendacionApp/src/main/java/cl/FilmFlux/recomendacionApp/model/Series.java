package cl.FilmFlux.recomendacionApp.model;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Series {
    @Id
    @NotNull
    private int id;
    @NotBlank
    private String imdb;
    @NotBlank
    private String titulo;
    @NotBlank
    private String director;
    @NotBlank
    private Date fechaEstreno;
    @NotBlank
    private String genero;
    @NotNull
    private int puntaje;
    @NotNull
    private int temporadas;
}
