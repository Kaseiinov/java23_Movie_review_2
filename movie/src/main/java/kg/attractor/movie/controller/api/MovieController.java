package kg.attractor.movie.controller.api;

import kg.attractor.movie.dto.MovieDto;
import kg.attractor.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("restProfile")
@RequestMapping("api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{movieId}")
    public MovieDto getMovieById(@PathVariable("movieId") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    public HttpStatus createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return HttpStatus.OK;
    }
}
