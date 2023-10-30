package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "movie-list-servlet", urlPatterns = "")
public class MovieListServlet extends HttpServlet {

    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;

    public MovieListServlet(MovieService movieService, SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String searchText = req.getParameter("searchText");
        String searchRating = req.getParameter("searchRating");
        if (searchText == null && searchRating == null) {
            context.setVariable("movies", this.movieService.listAll());
        }
        else {
            context.setVariable("movies", this.movieService.searchTitleAndRating(searchText, searchRating));
        }
        this.springTemplateEngine.process("listMovies.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("selectedMovie");
        int numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));
        resp.sendRedirect("/ticketOrder?title=" + title + "&numTickets=" + numberOfTickets);
    }
}
