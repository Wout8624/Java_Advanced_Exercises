package be.pxl.superhero_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    Optional<Superhero> findBySuperheroName(String superheroName);
}
