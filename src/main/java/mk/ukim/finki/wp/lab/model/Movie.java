package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Movie {

    private Long id;
    private String title;
    private String summary;
    private Double rating;
    private Production production;

    public Movie(String title, String summary, Double rating, Production production) {
        this.id = (long) (Math.random()*1000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }
}
