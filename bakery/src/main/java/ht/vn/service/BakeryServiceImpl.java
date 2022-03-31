package ht.vn.service;


import ht.vn.model.Bakery;
import ht.vn.model.User;
import ht.vn.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
@Transactional
public class BakeryServiceImpl implements BakeryService {
//    private List<Bakery> bakerys = new ArrayList<>();


    @Autowired
    private BakeryRepository bakeryRepository;

    @Override
    public List<Bakery> findAll() {
        return bakeryRepository.findAll();
    }

    @Override
    public Optional<Bakery> findById(Long id) {
        return bakeryRepository.findById(id);
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
        bakery.setDeleted(true);
        bakeryRepository.save(bakery);

    }

    @Override
    public List<Bakery> findAllActive() {
        return bakeryRepository.findAllByDeletedIsFalse();
    }

//    @Override
//    public void update(Long id, Bakery bakery) {
//
//        bakery.setId(id);
//        bakeryRepository.save(bakery);
//
////        for (Bakery b : bakerys) {
////            if (Objects.equals(b.getId(), id)) {
////                b = bakery;
////                break;
////            }
////        }
//    }
}