package kg.attractor.movie.service;

import kg.attractor.movie.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();

    MovieDto getMovieById(String id);

    void createMovie(MovieDto movieDto);

    List<MovieDto> getMovieListPage(int size, int page);
}
