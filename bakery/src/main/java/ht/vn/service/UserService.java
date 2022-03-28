package ht.vn.service;

import ht.vn.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserService extends IGeneralService<User>{
    List<User> fildAllActive();
}
