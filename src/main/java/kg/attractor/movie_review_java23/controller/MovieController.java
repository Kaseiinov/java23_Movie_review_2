package kg.attractor.movie_review_java23.controller;

import kg.attractor.movie_review_java23.dto.MovieDto;
import kg.attractor.movie_review_java23.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{movieId}")// http://localhost:8089/movies/movies/123
    public MovieDto getMovie(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    public HttpStatus createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("{movieId}")
    public HttpStatus deleteMovie(@PathVariable("movieId") String movieId) {
        // TODO implement delete logic
        return HttpStatus.OK;
    }

}
