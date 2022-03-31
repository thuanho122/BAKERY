package ht.vn.controller.rest;


import ht.vn.model.User;
import ht.vn.model.dto.UserDTO;
import ht.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("123456")){
            ModelAndView modelAndView = new ModelAndView("/success");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }

//    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("userDTO") UserDTO userDTO){
//        User user = userService
//        if(user == null){
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("user");
//            modelAndView.addObject("user", user);
//            return modelAndView;
//        }
//    }



}
