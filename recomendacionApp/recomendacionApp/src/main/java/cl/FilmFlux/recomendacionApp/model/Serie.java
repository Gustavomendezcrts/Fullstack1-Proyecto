package cl.FilmFlux.recomendacionApp.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_serie;

    @NotBlank
    private String imdb;

    @NotBlank
    private String titulo;

    @NotBlank
    private String director;

    @NotNull
    private Date fechaEstreno;

    @NotBlank
    private String genero;

    @NotNull
    private Integer puntaje;

    @NotNull
    private Integer temporadas;

    @OneToMany(mappedBy = "serie", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<Resena> resenas;
}