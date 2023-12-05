package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

@Controller
@RequestMapping("/allTicketOrdersController")
public class AllTicketOrdersController {

    private final TicketOrderService ticketOrderService;

    public AllTicketOrdersController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model) {
        List<TicketOrder> allTickets = ticketOrderService.listAll();
        model.addAttribute("allTickets", allTickets);
        model.addAttribute("filteredTickets", allTickets);
        return "ticketOrders";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        ticketOrderService.delete(id);
        return "redirect:/allTicketOrdersController";
    }


}
