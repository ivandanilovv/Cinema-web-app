package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitleLikeOrSummaryLike(String title, String summary);

    void deleteById(Long id);

    Movie findMovieById(Long id);

    List<Movie> findMoviesByTitleContainsAndRatingGreaterThanEqual(String title, Double rating);

}
