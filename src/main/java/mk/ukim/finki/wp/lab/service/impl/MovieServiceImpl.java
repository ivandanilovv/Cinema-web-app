package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.repository.impl.ProductionRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaMovieRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaProductionRepository;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final JpaMovieRepository movieRepository;
    private final JpaProductionRepository productionRepository;

    public MovieServiceImpl(JpaMovieRepository movieRepository, JpaProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.findAllByTitleLikeOrSummaryLike(text, text);
    }

    @Override
    public List<Movie> searchTitleAndRating(String title, String rating) {
        return movieRepository.findMoviesByTitleContainsAndRatingGreaterThanEqual(title, Double.valueOf(rating));
    }

    @Override
    public void save(String name, String summary, Double rating, Long id) {
        Production production = productionRepository.findProductionById(id);
        Movie m = new Movie(name, summary, rating, production);
        movieRepository.save(m);
    }

    @Override
    public void edit(Long id, String title, String summary, Double rating, Long production_id) {
        Movie m = movieRepository.findMovieById(id);
        m.setTitle(title);
        m.setSummary(summary);
        m.setRating(rating);

        Production p = productionRepository.findProductionById(production_id);
        m.setProduction(p);
        movieRepository.save(m);
    }

    @Override
    public Movie findById(Long movieId) {
        return this.movieRepository.findMovieById(movieId);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}

