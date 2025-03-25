package kg.attractor.movie.service;

import kg.attractor.movie.dto.MovieImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveImage(MovieImageDto movieImageDto);

    ResponseEntity<?> findByName(String imageName);

    ResponseEntity<?> findById(Long imageId);
}
