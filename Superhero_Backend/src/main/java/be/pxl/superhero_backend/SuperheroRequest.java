package be.pxl.superhero_backend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperheroRequest {
    private String firstName;
    private String lastName;
    private String superheroName;

    public SuperheroRequest(String firstName, String lastName, String superheroName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
    }

}