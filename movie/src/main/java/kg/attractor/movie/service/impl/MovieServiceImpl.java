package kg.attractor.movie.service.impl;

import kg.attractor.movie.dto.MovieDto;
import kg.attractor.movie.model.Director;
import kg.attractor.movie.model.Movie;
import kg.attractor.movie.service.MovieService;
import kg.attractor.movie.util.FileUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final List<Movie> movies;

//    @Autowired
    public MovieServiceImpl() {
        this.movies = new FileUtil().getMovies("movies.json");
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movies
                .stream()
                .map(e -> MovieDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .year(e.getYear())
                        .description(e.getDescription())
                        .build())
                .toList();

    }

    @Override
    public MovieDto getMovieById(String movieId) {
        int id = Integer.parseInt(movieId);
        return movies.stream()
                .filter(m -> m.getId() == id)
                .map(m -> MovieDto.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .year(m.getYear())
                        .description(m.getDescription())
                        .build())
                .findAny()
                .orElseThrow();
    }

    @Override
    public void createMovie(MovieDto movieDto) {
        movies.add(
                Movie.builder()
                        .id(movies.size() + 1)
                        .name(movieDto.getName())
                        .year(LocalDate.now().getYear())
                        .description(movieDto.getDescription())
                        .cast(new ArrayList<>())
                        .director(new Director())
                        .build()
        );
    }
}
