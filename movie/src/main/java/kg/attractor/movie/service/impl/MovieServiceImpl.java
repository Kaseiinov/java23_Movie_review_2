package kg.attractor.movie.service.impl;

import kg.attractor.movie.dao.DirectorDao;
import kg.attractor.movie.dao.MovieDao;
import kg.attractor.movie.dto.MovieDto;
import kg.attractor.movie.exceptions.MovieNotFoundException;
import kg.attractor.movie.model.Movie;
import kg.attractor.movie.service.DirectorService;
import kg.attractor.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;
    private final DirectorService directorService;

////    @Autowired
//    public MovieServiceImpl() {
//        this.movies = new FileUtil().getMovies("movies.json");
//    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieDao.getMovies();
        return movies
                .stream()
                .map(e -> MovieDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .year(e.getReleaseYear())
                        .description(e.getDescription())
                        .build())
                .toList();

    }

    @Override
    public MovieDto getMovieById(String movieId) {
        int id = Integer.parseInt(movieId);

        Movie movie = movieDao.getMovieById(id).orElseThrow(() -> new MovieNotFoundException());
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .year(movie.getReleaseYear())
                .description(movie.getDescription())
                .director(directorService.getDirectorById(movie.getDirectorId()))
                .build();
    }

    @Override
    public void createMovie(MovieDto movieDto) {
        List<Movie> movies = movieDao.getMovies();
        movies.add(
                Movie.builder()
                        .id(movies.size() + 1)
                        .name(movieDto.getName())
                        .releaseYear(LocalDate.now().getYear())
                        .description(movieDto.getDescription())
                        .directorId(1)
                        .build()
        );
    }
}
