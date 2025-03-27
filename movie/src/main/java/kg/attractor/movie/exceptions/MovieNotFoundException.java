package kg.attractor.movie.exceptions;

import java.util.NoSuchElementException;

public class MovieNotFoundException extends NoSuchElementException {
    public MovieNotFoundException() {
        super("Movie not found");
    }
}
