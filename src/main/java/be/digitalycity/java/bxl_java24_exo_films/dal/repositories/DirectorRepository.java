package be.digitalycity.java.bxl_java24_exo_films.dal.repositories;

import be.digitalycity.java.bxl_java24_exo_films.dl.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectorRepository extends JpaRepository<Director, UUID> {
}
