package cl.FilmFlux.recomendacionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.model.Serie;
import cl.FilmFlux.recomendacionApp.repository.SerieRepository;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> getSeries(){
        return serieRepository.findAll();
    }

    public Serie saveSerie(Serie serie){
        return serieRepository.save(serie);
    }

    public Serie getSerieId(int id){
        return serieRepository.findById(id).orElse(null);
    }

    public Serie updateSerie(Serie serie){
        if(!serieRepository.existsById(serie.getId())){
            return null;
        }
        return serieRepository.save(serie);
    }

    public void deleteSerie(int id){
        serieRepository.deleteById(id);
    }
}
