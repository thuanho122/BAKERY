package ht.vn.controller;

import ht.vn.model.Bakery;
import ht.vn.model.Role;
import ht.vn.model.Status;
import ht.vn.model.User;
import ht.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {
//    @Controller
//    @RequestMapping("/customers")
//    public class CustomerController {
//        @GetMapping
//        public ModelAndView showList(){
//            ModelAndView modelAndView = new ModelAndView("/customer/list");
//            return modelAndView;
//        }
//    }
    @Autowired
    private UserService userService;

//    @GetMapping
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
//        return modelAndView;
//    }

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");

        List<User> users = userService.fildAllActive();

        modelAndView.addObject("users", users);

        return modelAndView;
    }


//    @PutMapping("/delete")
//    public ResponseEntity<?> doDelete(@RequestBody User user) {
//        Optional<User> optionalUser = userService.findById(user.getId());
//        if (optionalUser.isPresent()) {
//            userService.deleteUserById(user.getId());
//            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
//        } else {
//            throw new IllegalStateException("fgewb");
//        }
//    }





//    @DeleteMapping("users/{userId}")
//    public ResponseEntity<?> doDelete(@PathVariable Long userId) {
//        Optional<User> optionalUser = userService.findById(userId);
//        if (optionalUser.isPresent()) {
//            userService.softDelete(optionalUser.get());
//            return new ResponseEntity<>("Delete customer successful", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Error for delete customer", HttpStatus.BAD_REQUEST);
//    }


}
