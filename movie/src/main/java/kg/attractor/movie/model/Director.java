package kg.attractor.movie.model;

import lombok.Data;

@Data
public class Director {
    private Long id;
    private String fullName;

    @Override
    public String toString() {
        return String.format("Режиссер: %s", fullName);
    }
}
