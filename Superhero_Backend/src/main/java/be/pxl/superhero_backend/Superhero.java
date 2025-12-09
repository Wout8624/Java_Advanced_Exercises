package be.pxl.superhero_backend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "superheroes")
@Getter
@Setter
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String superheroName;
    @ManyToMany
    private List<Mission> missions = new ArrayList<>();

    public Superhero() {
        //JPAonly
    }

    public Superhero(String firstName, String lastName, String superheroName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
    }

    @Override
    public String toString() {
        return superheroName;
    }
}