package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.TicketOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketOrderService {

    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets, LocalDateTime date);

    List<TicketOrder> listAll();

    List<TicketOrder> searchUsers(String username);

    public void delete(Long id);
}
