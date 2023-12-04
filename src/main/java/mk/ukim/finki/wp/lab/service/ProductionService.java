package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Production;

import java.util.List;

public interface ProductionService {
    public List<Production> findAll();

    Production findById(Long id);

}
