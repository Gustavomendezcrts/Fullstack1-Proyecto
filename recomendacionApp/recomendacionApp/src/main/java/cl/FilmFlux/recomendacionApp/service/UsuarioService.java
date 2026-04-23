package cl.FilmFlux.recomendacionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.repository.UsuarioRepository;
import cl.FilmFlux.recomendacionApp.model.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario user){
        return usuarioRepository.save(user);
    }

    public Usuario getUsuarioId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario user){
        if(!usuarioRepository.existsById(user.getId())){
            return null;
        }
        return usuarioRepository.save(user);
    }

    public void deleteUsuario(int id){
        usuarioRepository.deleteById(id);
    }
}
