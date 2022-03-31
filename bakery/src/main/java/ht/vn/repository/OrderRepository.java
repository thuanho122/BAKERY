package ht.vn.repository;

import ht.vn.model.Order;
import ht.vn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
