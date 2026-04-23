package cl.FilmFlux.recomendacionApp.repository;

import cl.FilmFlux.recomendacionApp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
}
