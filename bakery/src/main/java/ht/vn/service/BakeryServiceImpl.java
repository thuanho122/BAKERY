package ht.vn.service;


import ht.vn.model.Bakery;
import ht.vn.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BakeryServiceImpl implements BakeryService {


    @Autowired
    private BakeryRepository bakeryRepository;

    @Override
    public List<Bakery> findAll() {
        return bakeryRepository.findAll();
    }

    @Override
    public Optional<Bakery> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Bakery getById(Long id) {
        return bakeryRepository.getById(id);
    }

    @Override
    public Bakery save(Bakery bakery) {
        return bakeryRepository.save(bakery);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(Bakery bakery) {

    }
}
