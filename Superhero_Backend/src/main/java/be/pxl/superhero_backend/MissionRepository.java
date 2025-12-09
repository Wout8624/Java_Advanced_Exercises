package be.pxl.superhero_backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository  extends JpaRepository<Mission, Long> {


    Long id(Long id);
}
