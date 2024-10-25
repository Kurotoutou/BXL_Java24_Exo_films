package be.digitalycity.java.bxl_java24_exo_films.il.initializers;

import be.digitalycity.java.bxl_java24_exo_films.dal.repositories.DirectorRepository;
import be.digitalycity.java.bxl_java24_exo_films.dal.repositories.FilmRepository;
import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Director;
import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final FilmRepository filmRepository;
    private final DirectorRepository directorRepository;

    @Override
    public void run(String... args) throws Exception {

        if(directorRepository.count() == 0) {
            List<Director> directors = List.of(
                    new Director(
                            UUID.randomUUID(),
                            "Zach",
                            "Snyder",
                            LocalDate.of(1966, 3, 1)
                    ),
                    new Director(
                            UUID.randomUUID(),
                            "Lana & Lilly",
                            "Wachowskis",
                            LocalDate.of(1965, 6, 21)
                    ),
                    new Director(
                            UUID.randomUUID(),
                            "Alfonso",
                            "Cuarón",
                            LocalDate.of(1961, 11, 28)
                    )
            );
            directorRepository.saveAll(directors);
        }

        if(filmRepository.count() == 0) {
            List<Director> directors = directorRepository.findAll();
            List<Film> films = List.of(
                    new Film(
                            UUID.randomUUID(),
                            "Watchmen",
                            LocalTime.of(2,42,0),
                            "Dans une société sombre où les super-héros sont traqués, un ancien justicier découvre un " +
                                    "complot qui pourrait changer le monde. Dans ce thriller, les héros doivent confronter " +
                                    "leur passé et leurs idéaux pour sauver l'humanité… ou la détruire.",
                            LocalDate.of(2009, 2, 23),
                            directors.stream().filter(
                                    d -> d.getLastName().equals("Snyder")).findFirst().orElseThrow()
                    ),
                    new Film(
                            UUID.randomUUID(),
                            "V for Vendetta",
                            LocalTime.of(2, 13, 0),
                            "Dans un futur totalitaire, un mystérieux justicier masqué appelé \"V\" mène une révolution " +
                                    "contre l’oppression. Avec l’aide d’une jeune femme, il inspire le peuple à se soulever " +
                                    "et à réclamer sa liberté.",
                            LocalDate.of(2005, 12, 11),
                            directors.stream().filter(
                                    d -> d.getLastName().equals("Wachowskis")).findFirst().orElseThrow()
                    ),
                    new Film(
                            UUID.randomUUID(),
                            "Children of Men",
                            LocalTime.of(1, 49, 0),
                            "En 2027, l'humanité fait face à l'extinction, incapable de se reproduire. Un homme désillusionné " +
                                    "est entraîné malgré lui dans une mission : protéger la dernière femme enceinte. Une " +
                                    "course contre la montre pour l'avenir de la civilisation.",
                            LocalDate.of(2006, 9, 3),
                            directors.stream().filter(
                                    d -> d.getLastName().equals("Cuarón")).findFirst().orElseThrow()
                    )
            );
            filmRepository.saveAll(films);
        }
    }
}
