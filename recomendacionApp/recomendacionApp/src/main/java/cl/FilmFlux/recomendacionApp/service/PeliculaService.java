package cl.FilmFlux.recomendacionApp.service;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.model.Pelicula;
import cl.FilmFlux.recomendacionApp.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getPeliculas(){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo todas las peliculas | " + peliculaRepository.findAll().size() + " | Elementos");
        return peliculaRepository.findAll();
    }

    public List<Pelicula> getPeliculasByGenero(String genero){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo peliculas por genero: " + genero + " | " + peliculaRepository.findByGenero(genero).size() + " Elementos");
        return peliculaRepository.findByGenero(genero);
    }

    public Pelicula savePelicula(Pelicula peli){
        System.out.println("[" + LocalDateTime.now() + "] " + "Guardando pelicula: " + peli.getTitulo());
        return peliculaRepository.save(peli);
    }

    public Pelicula getPeliculaId(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo pelicula por ID: " + id);
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula updatePelicula(Pelicula peli){
        System.out.println("[" + LocalDateTime.now() + "] " + "Actualizando pelicula | ID: " + peli.getIdPelicula());
        if(!peliculaRepository.existsById(peli.getIdPelicula())){
            return null;
        }
        return peliculaRepository.save(peli);
    }

    public void deletePelicula(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Borrando Pelicula | ID: " + id);
        peliculaRepository.deleteById(id);
    }
}
