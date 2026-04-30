package cl.FilmFlux.recomendacionApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.FilmFlux.recomendacionApp.model.Serie;
import cl.FilmFlux.recomendacionApp.service.SerieService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/api/v1/series")
@RestController
public class SerieController {
    @Autowired
    private SerieService serieService;

    @GetMapping
    public ResponseEntity<List<Serie>> getSeries(){
        return ResponseEntity.ok(serieService.getSeries());
    }

    @PostMapping
    public ResponseEntity<Serie> saveSerie(@Valid @RequestBody Serie serie){
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.saveSerie(serie));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerie(@PathVariable int id){
        Serie serie = serieService.getSerieId(id);
        if(serie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> actualizarSerie(@PathVariable int id, @Valid @RequestBody Serie serie) {
        serie.setId_serie(id);
        Serie serieActualizada = serieService.updateSerie(serie);
        if (serieActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(serieActualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable int id) {
        serieService.deleteSerie(id);
        return ResponseEntity.noContent().build();
    }

}
