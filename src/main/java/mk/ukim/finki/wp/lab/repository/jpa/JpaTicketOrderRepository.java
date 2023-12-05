package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTicketOrderRepository extends JpaRepository<TicketOrder, Long> {

    List<TicketOrder> searchTicketOrderByClientNameIs(String name);

}
