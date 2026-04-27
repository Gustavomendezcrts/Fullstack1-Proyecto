package cl.FilmFlux.recomendacionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.model.Pelicula;
import cl.FilmFlux.recomendacionApp.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getPeliculas(){
        return peliculaRepository.findAll();
    }

    public Pelicula savePelicula(Pelicula peli){
        return peliculaRepository.save(peli);
    }

    public Pelicula getPeliculaId(int id){
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula updatePelicula(Pelicula peli){
        if(!peliculaRepository.existsById(peli.getId_pelicula())){
            return null;
        }
        return peliculaRepository.save(peli);
    }

    public void deletePelicula(int id){
        peliculaRepository.deleteById(id);
    }
}
