package be.digitalycity.java.bxl_java24_exo_films.bll.services;

import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface FilmService {

    List<Film> findAll();
    Film findById(UUID id);
    Film save(Film film, MultipartFile image);
    void update(Film film, MultipartFile image);
    void delete(UUID id);
}
