package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Production;
import mk.ukim.finki.wp.lab.repository.ProductionRepository;
import mk.ukim.finki.wp.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {
        return this.productionRepository.findAll();
    }

    @Override
    public Production findById(Long id) {
        return this.productionRepository.findById(id);
    }
}
