package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "all-ticket-orders", urlPatterns = "/allTicketOrders")
public class AllTicketOrdersServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final TicketOrderService ticketOrderService;

    public AllTicketOrdersServlet(SpringTemplateEngine springTemplateEngine, TicketOrderService ticketOrderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).
                buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String username = req.getParameter("users");
        context.setVariable("allTickets", ticketOrderService.listAll().stream().
                distinct().collect(Collectors.toList()));
        context.setVariable("filteredTickets", ticketOrderService.listAll());
        if (username != null) {
            context.setVariable("filteredTickets", ticketOrderService.searchUsers(username));
        }
        springTemplateEngine.process("ticketOrders.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("users");
        resp.sendRedirect("/allTicketOrders?users=" + username);
    }
}
