package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "cinema_users")
public class User {

    @Id
    private String username;

    private String name;

    private String surname;

    private String password;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @OneToMany
    private List<ShoppingCart> carts;

    public User(String username, String name, String surname, String password, LocalDate dateOfBirth, List<ShoppingCart> carts) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.carts = carts;
    }
}
