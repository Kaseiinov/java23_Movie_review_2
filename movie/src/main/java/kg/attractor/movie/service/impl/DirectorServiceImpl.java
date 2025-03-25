package kg.attractor.movie.service.impl;

import kg.attractor.movie.dao.DirectorDao;
import kg.attractor.movie.dto.DirectorDto;
import kg.attractor.movie.exceptions.DirectorNotFoundException;
import kg.attractor.movie.model.Director;
import kg.attractor.movie.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorDao directorDao;

    @Override
    public DirectorDto getDirectorById(int id) {
        Director director = directorDao.getDirectorById(id).orElseThrow(DirectorNotFoundException::new);
        return DirectorDto.builder()
                .id(director.getId())
                .fullName(director.getFullName())
                .build();
    }

}
