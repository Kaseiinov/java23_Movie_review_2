package kg.attractor.movie.service.impl;

import kg.attractor.movie.exceptions.ErrorResponseBody;
import kg.attractor.movie.service.ErrorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorServiceImpl implements ErrorService {

//    For base exceptions
    @Override
    public ErrorResponseBody makeResponse(Exception e){
        String msg = e.getMessage();
        return ErrorResponseBody.builder()
                .title(msg)
                .response(Map.of("errors", List.of(msg)))
                .build();
    }

//    For validation
    @Override
    public ErrorResponseBody makeResponse(BindingResult bindingResult) {
        Map<String, List<String>> response = new HashMap<>();
        bindingResult.getFieldErrors()
                .stream()
                .filter(err -> err.getDefaultMessage() != null)
                .forEach(err -> {
                    List<String> errors = new ArrayList<>();
                    errors.add(err.getDefaultMessage());
                    if(!response.containsKey(err.getField())){
                        response.put(err.getField(), errors);
                    }
                });
        return ErrorResponseBody.builder()
                .title("Validation Error")
                .response(response)
                .build();
    }
}
