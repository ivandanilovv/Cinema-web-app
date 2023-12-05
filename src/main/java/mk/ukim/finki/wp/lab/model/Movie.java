package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 3000)
    private String summary;
    private Double rating;
    @ManyToOne
    private Production production;

    public Movie(String title, String summary, Double rating, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }
}
