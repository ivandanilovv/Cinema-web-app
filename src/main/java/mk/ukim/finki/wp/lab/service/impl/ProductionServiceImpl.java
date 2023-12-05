package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.repository.impl.ProductionRepository;
import mk.ukim.finki.wp.lab.repository.jpa.JpaProductionRepository;
import mk.ukim.finki.wp.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductionServiceImpl implements ProductionService {

    private final JpaProductionRepository productionRepository;

    public ProductionServiceImpl(JpaProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {
        return this.productionRepository.findAll();
    }

    @Override
    public Production findById(Long id) {
        return this.productionRepository.findProductionById(id);
    }
}
