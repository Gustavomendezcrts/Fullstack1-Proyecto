package cl.FilmFlux.recomendacionApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.FilmFlux.recomendacionApp.model.Resena;
import cl.FilmFlux.recomendacionApp.service.ResenaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/api/v1/resenas")
@RestController
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public ResponseEntity<List<Resena>> getResenas(){
        return ResponseEntity.ok(resenaService.getResenas());
    }

    @PostMapping
    public ResponseEntity<Resena> saveResena(@Valid @RequestBody Resena resena){
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaService.saveResena(resena));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Resena> getResena(@PathVariable int id){
        Resena resena = resenaService.getResenaId(id);
        if(resena == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable int id, @Valid @RequestBody Resena resena) {
        resena.setId_resena(id);
        Resena resenaActualizada = resenaService.updateResena(resena);
        if (resenaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resenaActualizada);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable int id) {
        resenaService.deleteResena(id);
        return ResponseEntity.noContent().build();
    }

}
