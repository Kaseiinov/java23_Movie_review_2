package kg.attractor.movie.exceptions;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseBody {
    private String title;
    private Map<String , List<String>> response;
}
