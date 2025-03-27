package kg.attractor.movie.exceptions;

import java.util.NoSuchElementException;

public class DirectorNotFoundException extends NoSuchElementException {
    public DirectorNotFoundException() {
        super("Director not found");
    }
}
