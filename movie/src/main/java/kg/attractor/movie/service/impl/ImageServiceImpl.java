package kg.attractor.movie.service.impl;

import kg.attractor.movie.dao.MovieImageDao;
import kg.attractor.movie.dto.MovieImageDto;
import kg.attractor.movie.exceptions.ImageNotFoundException;
import kg.attractor.movie.model.MovieImage;
import kg.attractor.movie.service.ImageService;
import kg.attractor.movie.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final MovieImageDao  movieImageDao;
    private final FileUtil fileUtil;

    @Override
    public String saveImage(MovieImageDto movieImageDto) {
        String fileName = fileUtil.saveUploadFile(movieImageDto.getFile(), "images/");
        movieImageDao.saveImage(movieImageDto.getMovieId(), fileName);
        return fileName;
    }

    @Override
    public ResponseEntity<?> findByName(String imageName) {
        return fileUtil.getOutputFile(imageName, "images/", MediaType.IMAGE_JPEG);
    }

    @Override
    public ResponseEntity<?> findById(Long imageId) {
        MovieImage movieImage = movieImageDao.getImageById(imageId).orElseThrow(ImageNotFoundException::new);
        String fileName = movieImage.getFileName();
        return fileUtil.getOutputFile(fileName, "images/", MediaType.IMAGE_JPEG);
    }

    @Override
    public ResponseEntity<?> findByMovieId(long movieId){
        MovieImage image = movieImageDao.getImageById(movieId).orElseThrow(ImageNotFoundException::new);
        String fileName = image.getFileName();
        return fileUtil.getOutputFile(fileName, "images/", MediaType.IMAGE_JPEG);
    }
}
