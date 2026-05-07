package cl.FilmFlux.recomendacionApp.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.DTO.Resena_DTO;
import cl.FilmFlux.recomendacionApp.model.Resena;
import cl.FilmFlux.recomendacionApp.repository.ResenaRepository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> getResenas(){
        return resenaRepository.findAll();
    }

public List<Resena_DTO> getResenasByUsuario(int id){

    return resenaRepository.findByUsuario_idUsuario(id).stream()
            .map(r -> {

                String tipo;
                String titulo;
                Date fechaEstreno;
                Integer puntajeMedia;

                if (r.getPelicula() != null) {

                    tipo = "Pelicula";
                    titulo = r.getPelicula().getTitulo();
                    fechaEstreno = r.getPelicula().getFechaEstreno();
                    puntajeMedia = r.getPelicula().getPuntaje();

                } else {

                    tipo = "Serie";
                    titulo = r.getSerie().getTitulo();
                    fechaEstreno = r.getSerie().getFechaEstreno();
                    puntajeMedia = r.getSerie().getPuntaje();
                }

                return new Resena_DTO(
                        r.getPuntaje(),
                        r.getComentario(),
                        r.getUsuario().getNombre(),
                        tipo,
                        titulo,
                        fechaEstreno,
                        puntajeMedia
                );
            })
            .toList();
}

    public List<Resena> getResenasByPelicula(int id){
        List<Resena> listaResenas = new ArrayList<>();

        for(Resena resena : resenaRepository.findAll()){
            if(resena.getPelicula() != null
                && resena.getPelicula().getIdPelicula() == id){
                listaResenas.add(resena);
            }
        }
        return listaResenas;
    }

        public List<Resena> getResenasBySerie(int id){
        List<Resena> listaResenas = new ArrayList<>();

        for(Resena resena : resenaRepository.findAll()){
            if(resena.getSerie() != null
                && resena.getSerie().getIdSerie() == id){
                listaResenas.add(resena);
            }
        }
        return listaResenas;
    }

    public Resena saveResena(Resena resena){
        return resenaRepository.save(resena);
    }

    public Resena getResenaId(int id){
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena updateResena(Resena resena){
        if(!resenaRepository.existsById(resena.getIdResena())){
            return null;
        }
        return resenaRepository.save(resena);
    }

    public void deleteResena(int id){
        resenaRepository.deleteById(id);
    }
}
