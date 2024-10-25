package be.digitalycity.java.bxl_java24_exo_films.pl.controllers;

import be.digitalycity.java.bxl_java24_exo_films.bll.services.FilmService;
import be.digitalycity.java.bxl_java24_exo_films.pl.models.dtos.FilmDTO;
import be.digitalycity.java.bxl_java24_exo_films.pl.models.dtos.FilmDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public String getFilms(Model model) {

        try {
            List<FilmDTO> films = filmService.findAll().stream()
                    .map(FilmDTO::formFilm)
                    .toList();
            model.addAttribute("films", films);
            return "index";
        } catch (NoSuchElementException e) {
            return "error/error404";
        }
    }

    @GetMapping("/{id}")
    public String getFilm(
            @PathVariable
            UUID id,
            Model model
    ) {
        try {
            FilmDetailDTO filmDetailDTO = FilmDetailDTO.filmDetailDTO(filmService.findById(id));
            model.addAttribute("film", filmDetailDTO);
            return "details";
        } catch (NoSuchElementException e) {
            return "error/error404";
        }
    }
}
