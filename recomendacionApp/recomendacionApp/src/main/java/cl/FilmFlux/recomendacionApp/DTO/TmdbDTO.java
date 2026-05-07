package cl.FilmFlux.recomendacionApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbDTO {
    
    @JsonProperty("movie_results")
    private List<ContentResult> movieResults;

    @JsonProperty("tv_results")
    private List<ContentResult> tvResults;

    @JsonProperty("tv_episode_results")
    private List<ContentResult> tvEpisodeResults;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContentResult {
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("still_path") // Para episodios de TV
        private String stillPath;
    }
}