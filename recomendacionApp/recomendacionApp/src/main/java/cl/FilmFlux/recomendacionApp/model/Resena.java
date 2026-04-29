package cl.FilmFlux.recomendacionApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "resenas")
public class Resena {
    @Id
    @NotNull
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id_resena;
    @NotNull
    private int puntaje;
    @NotBlank
    private String comentario;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_pelicula", nullable = true)
    private Pelicula pelicula;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_serie", nullable = true)
    private Serie serie;
}
