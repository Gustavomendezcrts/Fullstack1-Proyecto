package cl.FilmFlux.recomendacionApp.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.model.Resena;
import cl.FilmFlux.recomendacionApp.repository.ResenaRepository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> getResenas(){
        return resenaRepository.findAll();
    }

    public List<Resena> getResenasByUsuario(int id){
        List<Resena> listaResenas = new ArrayList<>();

        for(Resena resena : resenaRepository.findAll()){
            if(resena.getUsuario().getId_usuario() == id){
                listaResenas.add(resena);
            }
        }
        return listaResenas;
    }

    public List<Resena> getResenasByPelicula(int id){
        List<Resena> listaResenas = new ArrayList<>();

        for(Resena resena : resenaRepository.findAll()){
            if(resena.getPelicula() != null
                && resena.getPelicula().getId_pelicula() == id){
                listaResenas.add(resena);
            }
        }
        return listaResenas;
    }

        public List<Resena> getResenasBySerie(int id){
        List<Resena> listaResenas = new ArrayList<>();

        for(Resena resena : resenaRepository.findAll()){
            if(resena.getSerie() != null
                && resena.getSerie().getId_serie() == id){
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
        if(!resenaRepository.existsById(resena.getId_resena())){
            return null;
        }
        return resenaRepository.save(resena);
    }

    public void deleteResena(int id){
        resenaRepository.deleteById(id);
    }
}
