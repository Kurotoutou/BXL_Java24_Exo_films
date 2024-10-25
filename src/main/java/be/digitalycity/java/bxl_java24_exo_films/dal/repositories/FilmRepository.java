package be.digitalycity.java.bxl_java24_exo_films.dal.repositories;

import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmRepository extends JpaRepository<Film, UUID> {
}
