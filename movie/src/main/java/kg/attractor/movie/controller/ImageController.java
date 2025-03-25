package kg.attractor.movie.controller;

import kg.attractor.movie.dto.MovieImageDto;
import kg.attractor.movie.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("images")
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

    @PostMapping
    public String uploadImage(MovieImageDto movieImageDto) {
        return imageService.saveImage(movieImageDto);

    }
}
