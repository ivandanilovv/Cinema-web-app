package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> listAll();
    List<Movie> searchMovies(String text);

    List<Movie> searchTitleAndRating(String title, String rating);
}
