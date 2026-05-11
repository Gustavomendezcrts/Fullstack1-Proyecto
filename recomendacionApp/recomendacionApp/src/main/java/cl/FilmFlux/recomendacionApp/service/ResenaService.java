package cl.FilmFlux.recomendacionApp.service;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

                System.out.println("[" + LocalDateTime.now() + "]" + " Trayendo Reseña por ID Usuario: " + id + " | Para Pelicula: " + titulo);
                } else {

                    tipo = "Serie";
                    titulo = r.getSerie().getTitulo();
                    fechaEstreno = r.getSerie().getFechaEstreno();
                    puntajeMedia = r.getSerie().getPuntaje();

                System.out.println("[" + LocalDateTime.now() + "]" + " Trayendo Reseña por ID Usuario: " + id + " | Para Serie: " + titulo);
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

    public List<Resena_DTO> getResenasByPelicula(int id){
        return resenaRepository.findByPelicula_idPelicula(id).stream()
        .map(r -> new Resena_DTO(
            r.getPuntaje(),
            r.getComentario(),
            r.getUsuario().getNombre(),
            "Pelicula",
            r.getPelicula().getTitulo(),
            r.getPelicula().getFechaEstreno(),
            r.getPelicula().getPuntaje()
        )).toList();
    }

    public List<Resena_DTO> getResenasBySerie(int id){
        return resenaRepository.findBySerie_idSerie(id).stream()
        .map(r -> new Resena_DTO(
            r.getPuntaje(),
            r.getComentario(),
            r.getUsuario().getNombre(),
            "Serie",
            r.getSerie().getTitulo(),
            r.getSerie().getFechaEstreno(),
            r.getSerie().getPuntaje()
        )).toList();
    }
}
