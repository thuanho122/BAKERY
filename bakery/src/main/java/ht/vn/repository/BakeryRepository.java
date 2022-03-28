package ht.vn.repository;

import ht.vn.model.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Long> {
}
