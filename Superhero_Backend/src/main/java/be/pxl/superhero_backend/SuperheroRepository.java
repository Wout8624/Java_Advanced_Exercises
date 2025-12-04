package be.pxl.superhero_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}
