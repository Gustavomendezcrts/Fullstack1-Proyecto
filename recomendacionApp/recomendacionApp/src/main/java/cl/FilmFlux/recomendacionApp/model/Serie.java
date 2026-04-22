package cl.FilmFlux.recomendacionApp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
