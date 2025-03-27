package kg.attractor.movie.service;

import kg.attractor.movie.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    //    For base exceptions
    ErrorResponseBody makeResponse(Exception e);

    //    For validation
    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
