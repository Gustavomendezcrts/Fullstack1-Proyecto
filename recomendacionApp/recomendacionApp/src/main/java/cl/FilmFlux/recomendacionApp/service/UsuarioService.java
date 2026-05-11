package cl.FilmFlux.recomendacionApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.FilmFlux.recomendacionApp.repository.UsuarioRepository;
import cl.FilmFlux.recomendacionApp.model.Usuario;
import cl.FilmFlux.recomendacionApp.DTO.Usuario_DTO;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario_DTO> getUsuarios(){
        return usuarioRepository.findAll().stream()
        .map(u -> new Usuario_DTO(
            u.getNombre(),
            u.getGustoPrincipal(),
            u.getGustoSecundario()
        )).toList();
    }

    public Usuario saveUsuario(Usuario user){
        return usuarioRepository.save(user);
    }

    public Usuario getUsuarioId(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario user){
        if(!usuarioRepository.existsById(user.getIdUsuario())){
            return null;
        }
        return usuarioRepository.save(user);
    }

    public void deleteUsuario(int id){
        usuarioRepository.deleteById(id);
    }

    public Usuario_DTO getUsuarioDTO(int id){
        Usuario user = usuarioRepository.findById(id).orElse(null);
        return new Usuario_DTO(
            user.getNombre(),
            user.getGustoPrincipal(),
            user.getGustoSecundario()
        );
    }
}
