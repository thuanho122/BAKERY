package ht.vn.controller;

import ht.vn.model.Bakery;
import ht.vn.model.User;
import ht.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
@RequestMapping("/users")
public class UserController {
//    @controller
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
//        modelAndView.setViewName("layouts");
//        return modelAndView;
//    }

    @GetMapping
    public ModelAndView showListPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user");

        List<User> user = userService.fildAllActive();

        modelAndView.addObject("users", user);

        return modelAndView;
    }

}
