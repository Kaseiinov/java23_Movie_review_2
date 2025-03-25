package kg.attractor.movie.exceptions;

public class DirectorNotFoundException extends RuntimeException {
    public DirectorNotFoundException() {
        super("Director not found");
    }
}
