package ht.vn.repository;

import ht.vn.model.Bakery;
import ht.vn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
    List<Bakery> findAllByDeletedIsFalse();
//    void update(Long id, Bakery bakery);
}
