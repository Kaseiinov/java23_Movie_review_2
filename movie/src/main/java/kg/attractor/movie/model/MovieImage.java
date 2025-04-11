package kg.attractor.movie.model;

import lombok.*;

@Getter
@Setter
public class MovieImage {
    private Long id;
    private Long movieId;
    private String fileName;
}
