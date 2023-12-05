package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String address;

    @OneToMany
    private List<Movie> movies;

    public Production(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
    }
}
