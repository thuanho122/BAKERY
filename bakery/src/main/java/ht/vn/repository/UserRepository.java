package ht.vn.repository;

import ht.vn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByDeletedIsFalse();
//    boolean existsByPasswordAndEmail(String password, String email);
}
