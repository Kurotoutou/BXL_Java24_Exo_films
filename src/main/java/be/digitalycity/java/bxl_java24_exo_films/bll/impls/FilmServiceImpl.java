package be.digitalycity.java.bxl_java24_exo_films.bll.impls;

import be.digitalycity.java.bxl_java24_exo_films.bll.services.FilmService;
import be.digitalycity.java.bxl_java24_exo_films.dal.repositories.FilmRepository;
import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film findById(UUID id) {
        Film film = filmRepository.findById(id).orElseThrow();
        return film;
    }

    @Override
    public Film save(Film film, MultipartFile image) {
        return null;
    }

    @Override
    public void update(Film film, MultipartFile image) {

    }

    @Override
    public void delete(UUID id) {

    }
}
