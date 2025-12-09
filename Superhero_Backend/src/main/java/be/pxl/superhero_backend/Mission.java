package be.pxl.superhero_backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Missions")
@Getter
@Setter
public class Mission {
    @Id
    private Long id;
    private String name;
    private boolean completed = false;
    @ManyToMany(mappedBy = "missions")
    private List<Superhero> superheroes = new ArrayList<>();

    public Mission() {
        // jpa only amk
    }

    public Mission(String name) {
        this.name = name;
    }

    public Mission(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }
}
