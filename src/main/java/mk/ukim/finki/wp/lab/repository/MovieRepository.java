package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    public static List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        movies.add(new Movie("The Shawshank Redemption", "Over the course of several years, two convicts " +
                "form a friendship, seeking consolation and, eventually, redemption through basic compassion.",
                9.3));
        movies.add(new Movie("The Godfather", "Don Vito Corleone, head of a mafia family, decides to " +
                "hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives" +
                " of his loved ones in grave danger.", 9.2));
        movies.add(new Movie("The Dark Knight", "When the menace known as the Joker wreaks havoc and " +
                "chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests " +
                "of his ability to fight injustice.", 9.0));
        movies.add(new Movie("Schindler's List", "In German-occupied Poland during World War II, " +
                "industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing " +
                "their persecution by the Nazis.", 9.0));
        movies.add(new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap maker" +
                " form an underground fight club that evolves into much more.", 8.8));
        movies.add(new Movie("Inception", "A thief who steals corporate secrets through the use of " +
                "dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., " +
                "but his tragic past may doom the project and his team to disaster.", 8.8));
        movies.add(new Movie("Se7en", "Two detectives, a rookie and a veteran, hunt a serial killer " +
                "who uses the seven deadly sins as his motives.", 8.6));
        movies.add(new Movie("The Prestige", "After a tragic accident, two stage magicians in 1890s" +
                " London engage in a battle to create the ultimate illusion while sacrificing everything they have " +
                "to outwit each other.", 8.5));
        movies.add(new Movie("Shutter Island", "Teddy Daniels and Chuck Aule, two US marshals, are " +
                "sent to an asylum on a remote island in order to investigate the disappearance of a patient, where " +
                "Teddy uncovers a shocking truth about the place.", 8.2));
        movies.add(new Movie("Zodiac", "Between 1968 and 1983, a San Francisco cartoonist becomes an " +
                "amateur detective obsessed with tracking down the Zodiac Killer, an unidentified individual who" +
                " terrorizes Northern California with a killing spree.", 7.7));
    }

    public List<Movie> findAll() {
        return movies;
    }

    public List<Movie> searchMovies(String text) {
        return movies.stream().filter(r -> r.getTitle().contains(text)
                || r.getSummary().contains(text)).collect(Collectors.toList());
    }

    public List<Movie> searchTitleAndRating(String title, String rating) {
        return movies.stream().filter(r -> r.getTitle().toLowerCase().contains(title.toLowerCase())
         && r.getRating() >= Double.parseDouble(rating)).collect(Collectors.toList());
    }
}
