package kg.attractor.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MovieImageDto {
    private MultipartFile file;
    private Long movieId;
}
