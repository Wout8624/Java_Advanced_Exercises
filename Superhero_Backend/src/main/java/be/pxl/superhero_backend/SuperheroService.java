package be.pxl.superhero_backend;


import java.util.List;

public interface SuperheroService {
    List<SuperheroDTO> findAllSuperheroes();

    SuperheroDTO findSuperheroById(Long superheroId);

    Long createSuperhero(SuperheroRequest superheroRequest);

    SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest);

    boolean deleteSuperhero(Long superheroId);
}