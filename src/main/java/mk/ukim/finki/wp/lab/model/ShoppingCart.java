package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime dateCreated;

    @ManyToMany
    private List<TicketOrder> ticketOrders;

    public ShoppingCart(Long id, User user, LocalDateTime dateCreated, List<TicketOrder> ticketOrders) {
        this.id = id;
        this.user = user;
        this.dateCreated = dateCreated;
        this.ticketOrders = ticketOrders;
    }
}
