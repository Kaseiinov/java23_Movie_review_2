package kg.attractor.movie.controller.api;

import kg.attractor.movie.dto.MovieImageDto;
import kg.attractor.movie.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getImageById(@RequestParam(name = "id") Long id) {
        return imageService.findById(id);
    }

    @GetMapping("{imageName}")
    public ResponseEntity<?> getImageByName(@PathVariable String imageName) {
        return imageService.findByName(imageName);
    }

    @GetMapping("movies/{movieId}")
    public ResponseEntity<?> getImageByMovieId(@PathVariable Long movieId) {
        return imageService.findByMovieId(movieId);
    }

    @PostMapping
    public String uploadImage(MovieImageDto movieImageDto) {
        return imageService.saveImage(movieImageDto);

    }


}
