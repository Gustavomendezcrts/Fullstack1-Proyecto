package cl.FilmFlux.recomendacionApp.service;

import java.time.LocalDateTime;
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
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo todas las series: | " + serieRepository.findAll().size() + " Elementos");
        return serieRepository.findAll();
    }

    public Serie saveSerie(Serie serie){
        System.out.println("[" + LocalDateTime.now() + "] " + "Guardando serie: " + serie.getTitulo());
        return serieRepository.save(serie);
    }

    public Serie getSerieId(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo serie por ID: " + id);
        return serieRepository.findById(id).orElse(null);
    }

    public Serie updateSerie(Serie serie){
        System.out.println("[" + LocalDateTime.now() + "] " + "Actualizando serie | ID: " + serie.getIdSerie());
        if(!serieRepository.existsById(serie.getIdSerie())){
            return null;
        }
        return serieRepository.save(serie);
    }

    public void deleteSerie(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Borrando serie | ID: " + id);
        serieRepository.deleteById(id);
    }
}
