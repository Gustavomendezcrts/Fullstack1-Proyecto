package cl.FilmFlux.recomendacionApp.service;

import cl.FilmFlux.recomendacionApp.DTO.TmdbDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TmdbApiService {

    @Autowired
    @Qualifier("tmdbWebClient")
    private WebClient tmdbWebClient;

    private final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

public String obtenerUrlPortada(String imdbId) {
    try {
        TmdbDTO response = tmdbWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/find/{external_id}")
                        .queryParam("external_source", "imdb_id")
                        .queryParam("language", "es-ES")
                        .build(imdbId))
                .retrieve()
                .bodyToMono(TmdbDTO.class)
                .block();

        if (response != null) {
            // 1. Intentar buscar en Películas
            if (response.getMovieResults() != null && !response.getMovieResults().isEmpty()) {
                return extraerPath(response.getMovieResults().get(0));
            }
            // 2. Si no hay, intentar en Series de TV
            if (response.getTvResults() != null && !response.getTvResults().isEmpty()) {
                return extraerPath(response.getTvResults().get(0));
            }
            // 3. Si no hay, intentar en Episodios
            if (response.getTvEpisodeResults() != null && !response.getTvEpisodeResults().isEmpty()) {
                return extraerPath(response.getTvEpisodeResults().get(0));
            }
        }
    } catch (Exception e) {
        System.err.println("Error en TMDb: " + e.getMessage());
    }
    return null;
}

// Método auxiliar para limpiar el código
private String extraerPath(TmdbDTO.ContentResult result) {
    String path = (result.getPosterPath() != null) ? result.getPosterPath() : result.getStillPath();
    return (path != null) ? IMAGE_BASE_URL + path : null;
}
}   