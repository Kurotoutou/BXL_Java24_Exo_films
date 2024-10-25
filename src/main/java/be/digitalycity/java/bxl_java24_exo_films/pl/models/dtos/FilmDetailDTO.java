package be.digitalycity.java.bxl_java24_exo_films.pl.models.dtos;

import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Director;
import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record FilmDetailDTO(
        UUID id,
        String title,
        Director director,
        LocalTime duration,
        LocalDate release,
        String picture,
        String pitch
) {

    public static FilmDetailDTO filmDetailDTO(Film film) {
        return new FilmDetailDTO(
                film.getId(),
                film.getTitle(),
                film.getDirector(),
                film.getDuration(),
                film.getRelease(),
                film.getPicture(),
                film.getPitch()
        );
    }
}
