package kg.attractor.movie.service.impl;

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

    @Override
    public List<MovieDto> getMovieListPage(int page, int size){
        int total =  movieDao.getMovieCount();

        int offset = page * size;
        int lastPage = total % size;
        if(page<=0){
            offset = 0;
        }
        if(page > lastPage){
            offset = total - lastPage;
        }
        if(lastPage == 0){
            offset = total - size;
        }
        List<Movie> movies = movieDao.getMoviePagination(offset, size);

        return movies.stream()
                .map(e -> MovieDto
                        .builder()
                        .id(e.getId())
                        .name(e.getName())
                        .year(e.getReleaseYear())
                        .description(e.getDescription())
                        .build())
                .toList();

    }
}
