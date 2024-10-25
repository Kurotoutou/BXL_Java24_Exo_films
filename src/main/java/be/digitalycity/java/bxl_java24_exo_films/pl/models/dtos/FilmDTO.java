package be.digitalycity.java.bxl_java24_exo_films.pl.models.dtos;

import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record FilmDTO(
        UUID id,
        String title,
        LocalTime duration
) {

    public static FilmDTO formFilm(Film film) {
        return new FilmDTO(
                film.getId(),
                film.getTitle(),
                film.getDuration()
        );
    }
}
