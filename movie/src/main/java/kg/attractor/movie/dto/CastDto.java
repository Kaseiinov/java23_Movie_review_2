package kg.attractor.movie.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CastDto {
    private Long id;
    private String fullName;
    private String role;
}
