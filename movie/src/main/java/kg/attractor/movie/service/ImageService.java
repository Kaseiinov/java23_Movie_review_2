package kg.attractor.movie.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveImage(MultipartFile file);

    ResponseEntity<?> findByName(String imageName);
}
