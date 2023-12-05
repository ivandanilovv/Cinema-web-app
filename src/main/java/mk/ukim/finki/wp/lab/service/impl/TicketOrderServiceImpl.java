package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.repository.impl.TicketOrderRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaTicketOrderRepository;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final JpaTicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(JpaTicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    public List<TicketOrder> listAll() {
        return  ticketOrderRepository.findAll();
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets, LocalDateTime date) {
        TicketOrder ticketOrder = new TicketOrder(movieTitle, clientName, address, (long) numberOfTickets, date);
        ticketOrderRepository.save(ticketOrder);
        return ticketOrder;
    }

    @Override
    public List<TicketOrder> searchUsers(String username) {
        return ticketOrderRepository.searchTicketOrderByClientNameIs(username);
    }

    public void delete(Long id) {
        ticketOrderRepository.deleteById(id);
    }
}
