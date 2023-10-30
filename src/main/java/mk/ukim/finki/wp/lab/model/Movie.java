package mk.ukim.finki.wp.lab.model;

import lombok.Data;

@Data
public class Movie {

    private String title;
    private String summary;
    private Double rating;

    public Movie(String title, String summary, Double rating) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
    }
}
