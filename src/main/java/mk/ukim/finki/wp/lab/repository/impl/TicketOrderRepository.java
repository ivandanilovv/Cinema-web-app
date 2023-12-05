package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketOrderRepository {

    public static List<TicketOrder> ticketOrders = new ArrayList<>();

    public TicketOrderRepository() {
//        ticketOrders.add(new TicketOrder("The Godfather",
//                "Ivan Danilov", "Adresa 1", 1L));
//        ticketOrders.add(new TicketOrder("Inception",
//                "Marko Markovski", "Adresa 1", 7L));
//        ticketOrders.add(new TicketOrder("Se7en",
//                "Ivan Danilov", "Adresa 1", 2L));
    }

    public List<TicketOrder> getAllTicketOrders() {

        return ticketOrders;
    }

    public void placeOrder(TicketOrder ticketOrder) {
        ticketOrders.add(ticketOrder);
    }

    public List<TicketOrder> searchTickets(String username) {
        return ticketOrders.stream().filter(r -> r.getClientName().equals(username)).collect(Collectors.toList());
    }
}
