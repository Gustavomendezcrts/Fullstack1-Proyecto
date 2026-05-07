package cl.FilmFlux.recomendacionApp.controller;

import cl.FilmFlux.recomendacionApp.service.TmdbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tmdb")
public class TmdbController {

    @Autowired
    private TmdbApiService tmdbApiService;

    @GetMapping("/{imdbCode}")
    public ResponseEntity<Map<String, Object>> obtenerPortada(@PathVariable String imdbCode) {
        String urlPoster = tmdbApiService.obtenerUrlPortada(imdbCode);
        
        Map<String, Object> response = new HashMap<>();
        response.put("imdbId", imdbCode);

        if (urlPoster != null) {
            response.put("posterUrl", urlPoster);
            response.put("found", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("posterUrl", null);
            response.put("found", false);
            response.put("message", "No se encontró el póster para el código proporcionado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}