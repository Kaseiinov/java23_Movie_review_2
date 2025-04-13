package kg.attractor.movie.controller;

import kg.attractor.movie.dto.CastDto;
import kg.attractor.movie.dto.MovieDto;
import kg.attractor.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/movies";
    }

    @GetMapping("create")
    public String createMovie(Model model) {
        return "movies/new_movie";
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String createMovie(
            @RequestParam(name = "castMemberRole") String castMemberRole,
            @RequestParam(name = "castMemberName") String castMemberName,
            MovieDto movieDto
    ){
        movieService.createMovie(MovieDto.builder()
                        .name(movieDto.getName())
                        .year(movieDto.getYear())
                        .description(movieDto.getDescription())
                        .director(movieDto.getDirector())
                        .cast(List.of(CastDto.builder()
                                        .fullName(castMemberName)
                                        .role(castMemberRole)
                                .build()))
                .build());
        return "redirect:/movies";
    }
}
