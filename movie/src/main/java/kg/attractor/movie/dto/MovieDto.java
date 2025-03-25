package kg.attractor.movie.dto;

import kg.attractor.movie.model.Cast;
import kg.attractor.movie.model.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
    private Integer year;
    private String description;
    private DirectorDto director;
    private List<Cast> cast;

}
