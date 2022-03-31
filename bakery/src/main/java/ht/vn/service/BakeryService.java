package ht.vn.service;

import ht.vn.model.Bakery;
import ht.vn.model.User;

import java.util.List;

public interface BakeryService extends IGeneralService<Bakery> {
//    void update(Long id, Bakery bakery);
List<Bakery> findAllActive();
}

