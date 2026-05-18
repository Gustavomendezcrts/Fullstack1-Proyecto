package cl.FilmFlux.recomendacionApp.service;

import java.time.LocalDateTime;
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
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo todos los usuarios | " + usuarioRepository.findAll().size() + " Elementos");
        return usuarioRepository.findAll().stream()
        .map(u -> new Usuario_DTO(
            u.getNombre(),
            u.getGustoPrincipal(),
            u.getGustoSecundario()
        )).toList();
    }

    public Usuario_DTO getUsuarioById(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo a usuario | ID: " + id);
        Usuario user = usuarioRepository.findById(id).orElse(null);
        return new Usuario_DTO(
            user.getNombre(),
            user.getGustoPrincipal(),
            user.getGustoSecundario()
        );
    }

    public Usuario saveUsuario(Usuario user){
        System.out.println("[" + LocalDateTime.now() + "] " + "Guardando usuario: " + user.getNombre());
        return usuarioRepository.save(user);
    }

    // se usa este metodo para poder buscar al usuario
    public Usuario getUsuarioId(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Trayendo a usuario | ID: " + id);
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario user){
        System.out.println("[" + LocalDateTime.now() + "] " + "Actualizando a usuario | ID: " + user.getIdUsuario());
        if(!usuarioRepository.existsById(user.getIdUsuario())){
            return null;
        }
        return usuarioRepository.save(user);
    }

    public void deleteUsuario(int id){
        System.out.println("[" + LocalDateTime.now() + "] " + "Borrando usuario | ID: " + id);
        usuarioRepository.deleteById(id);
    }

    public Usuario_DTO getUsuarioByUsername(String username){
        System.out.println("[" + LocalDateTime.now() + "] " + "Buscando usuario: " + username);
        Usuario user = usuarioRepository.findByNombre(username);
        if(user != null){
            System.out.println("[" + LocalDateTime.now() + "] " + "Usuario encontrado: " + user.getIdUsuario());
            return new Usuario_DTO(
                user.getNombre(),
                user.getGustoPrincipal(),
                user.getGustoSecundario());
        }else{
            System.out.println("[" + LocalDateTime.now() + "] " + "Usuario no encontrado");
            return null;
        }
    }
}
