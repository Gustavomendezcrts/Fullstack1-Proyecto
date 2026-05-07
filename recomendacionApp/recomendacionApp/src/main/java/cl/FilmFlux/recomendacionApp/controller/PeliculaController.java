package cl.FilmFlux.recomendacionApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.FilmFlux.recomendacionApp.model.Pelicula;
import cl.FilmFlux.recomendacionApp.service.PeliculaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/api/v1/peliculas")
@RestController
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas(){
        return ResponseEntity.ok(peliculaService.getPeliculas());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Pelicula>> getPeliculasByGenero(@PathVariable String genero){
        return ResponseEntity.ok(peliculaService.getPeliculasByGenero(genero));
    }

    @PostMapping
    public ResponseEntity<Pelicula> savePelicula(@Valid @RequestBody Pelicula pelicula){
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaService.savePelicula(pelicula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable int id, @Valid @RequestBody Pelicula peli) {
        peli.setIdPelicula(id);
        Pelicula peliActualizada = peliculaService.updatePelicula(peli);
        if (peliActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(peliActualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable int id) {
        peliculaService.deletePelicula(id);
        return ResponseEntity.noContent().build();
    }

}
