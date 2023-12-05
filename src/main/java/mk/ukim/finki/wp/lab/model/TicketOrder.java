package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TicketOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieTitle;

    private String clientName;

    private String clientAddress;

    private Long numberOfTickets;

    @ManyToOne
    private User user;

    public TicketOrder(String movieTitle, String clientName, String clientAddress, Long numberOfTickets) {
        this.movieTitle = movieTitle;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
