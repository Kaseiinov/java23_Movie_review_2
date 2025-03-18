package kg.attractor.movie.service.impl;

import kg.attractor.movie.service.ImageService;
import kg.attractor.movie.util.FileUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String saveImage(MultipartFile file) {
        FileUtil fu = new FileUtil();
        String fileName = fu.saveUploadFile(file, "images/");
        return fileName;
    }

    @Override
    public ResponseEntity<?> findByName(String imageName) {
        return new FileUtil().getOutputFile(imageName, "images/", MediaType.IMAGE_JPEG);
    }
}
