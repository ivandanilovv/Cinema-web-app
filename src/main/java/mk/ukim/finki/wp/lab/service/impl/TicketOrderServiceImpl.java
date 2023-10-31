package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.repository.TicketOrderRepository;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    public List<TicketOrder> listAll() {
        return  ticketOrderRepository.getAllTicketOrders();
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        TicketOrder ticketOrder = new TicketOrder(movieTitle, clientName, address, (long) numberOfTickets);
        ticketOrderRepository.placeOrder(ticketOrder);
        return ticketOrder;
    }

    @Override
    public List<TicketOrder> searchUsers(String username) {
        return ticketOrderRepository.searchTickets(username);
    }
}
