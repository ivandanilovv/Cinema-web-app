package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.Production;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductionRepository {

    public static List<Production> productions = new ArrayList<>();


    public ProductionRepository() {
        productions.add(new Production("CBS Films", "USA", "Los Angeles"));
        productions.add(new Production("Columbia Pictures", "USA", "Los Angeles"));
        productions.add(new Production("DreamWorks", "USA", "Los Angeles"));
        productions.add(new Production("Netflix", "USA", "Los Angeles"));
        productions.add(new Production("Warner Bros.", "USA", "Los Angeles"));
    }
    public List<Production> findAll() {
        return productions;
    }

    public Production findById(Long id) {
        for (Production production : productions) {
            if (production.getId().equals(id)) {
                return production;
            }
        }
        return null;
    }

}
