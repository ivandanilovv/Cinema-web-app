package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> listAll();

    List<Movie> searchMovies(String text);

    List<Movie> searchTitleAndRating(String title, String rating);

    public void save(String name, String summary, Double rating, Long id);

    Movie findById(Long movieId);

    void delete(Long id);

}
