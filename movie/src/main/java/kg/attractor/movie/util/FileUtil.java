package kg.attractor.movie.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import kg.attractor.movie.model.Movie;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUtil {

    private final Gson gson;
    private final static String UPLOAD_DIR = "data/";

//    @Autowired
    public FileUtil() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Movie> getMovies(String path) {
        Type listType = new TypeToken<Map<String, List<Movie>>>() {
        }.getType();
        try (Reader reader = new FileReader(UPLOAD_DIR + path)) {
            Map<String, List<Movie>> movies = gson.fromJson(reader, listType);
            return movies.get("movies");

        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @SneakyThrows
    public String saveUploadFile(MultipartFile file, String subDir) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "_" + file.getOriginalFilename();

        Path pathDir = Paths.get(UPLOAD_DIR + subDir);
        Files.createDirectories(pathDir);

        Path filePath = Paths.get(pathDir + "/" + resultFileName);
        if(!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        try(OutputStream os = Files.newOutputStream(filePath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultFileName;
    }

    @SneakyThrows
    public ResponseEntity<?> getOutputFile(String fileName, String subDir, MediaType mediaType) {
        try{
            byte[] image = Files.readAllBytes(Paths.get(UPLOAD_DIR + subDir + fileName));
            Resource resource = new ByteArrayResource(image);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + fileName + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(mediaType)
                    .body(resource);
        } catch (NoSuchFileException nsf) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No such file");

        }
    }
}
