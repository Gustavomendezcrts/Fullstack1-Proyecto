package cl.FilmFlux.recomendacionApp.controller;

import cl.FilmFlux.recomendacionApp.service.TmdbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tmdb")
public class TmdbController {

    @Autowired
    private TmdbApiService tmdbApiService;

    @GetMapping("/{imdbCode}")
    public ResponseEntity<List<Object>> obtenerPortada(@PathVariable String imdbCode) {
        String urlPoster = tmdbApiService.obtenerUrlPortada(imdbCode);
        
        // Creamos una lista en lugar de un mapa
        List<Object> response = new ArrayList<>();
        System.out.println("TMDB API -> Busqueda IMDB:" + imdbCode);

        if (urlPoster != null) {
            response.add("ID: " + imdbCode);
            response.add("Poster: " + urlPoster);
            response.add("Status: Encontrado");
            return ResponseEntity.ok(response);
        } else {
            response.add("ID: " + imdbCode);
            response.add("Poster: No encontrado");
            response.add("Status: No encontrado");
            response.add("Error: No se encontró el póster para el código proporcionado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}