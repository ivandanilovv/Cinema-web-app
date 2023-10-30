package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import mk.ukim.finki.wp.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return null;
    }
}
