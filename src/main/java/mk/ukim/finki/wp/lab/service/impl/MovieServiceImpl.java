package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.repository.MovieRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    @Override
    public List<Movie> searchTitleAndRating(String title, String rating) {
        return movieRepository.searchTitleAndRating(title, rating);
    }

    @Override
    public void save(String name, String summary, Double rating, Long id) {
        movieRepository.save(name,summary,rating, id);
    }

    @Override
    public Movie findById(Long movieId) {
        return this.movieRepository.findById(movieId);
    }

    @Override
    public void delete(Long id) {
        movieRepository.delete(id);
    }
}

