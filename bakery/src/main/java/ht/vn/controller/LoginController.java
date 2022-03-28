package ht.vn.controller;

//import ht.vn.service.UserService;
import com.sun.tools.internal.ws.processor.model.Model;
import ht.vn.model.Role;
import ht.vn.model.Status;
import ht.vn.model.User;
import ht.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("")
public class LoginController {

@Autowired
private UserService userService;

    @GetMapping("/login")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @PostMapping("/login")
//    public ModelAndView login(@ModelAttribute("login") User login){
//        User user = UserDao.checkLogin(login);
//        if(user == null){
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("user");
//            modelAndView.addObject("user", user);
//            return modelAndView;
//        }
//    }

//    @PostMapping("/login")
//    public ModelAndView submit(@ModelAttribute("user") User user) {
//        if (user != null && user.getEmail() != null & user.getPassword() != null) {
//            if (user.getEmail().equals("chandra") && user.getPassword().equals("chandra123")) {
//                ModelAndView modelAndView = new ModelAndView("user");
//
//                modelAndView.addObject("msg", user.getEmail());
//                return modelAndView;
//            } else {
////                model.addAttribute("error", "Invalid Details");
//                return modelAndView;
//            }
//        } else {
//            model.addAttribute("error", "Please enter Details");
//            return "login";
//        }
//    }

//    @GetMapping("/user")
//    public ModelAndView showUsers() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
//        return modelAndView;
//    }

//    @GetMapping("/test")
//    public void test(){
//        User user =  new User("thuan", "thuan@gmail.com", "0987621312", 19, "hue", Status.BLOCKED, "thuan", Role.ADMIN);
//        User user1 =  new User("haha", "haha@gmail.com", "0981234567", 19, "hue", Status.BLOCKED, "haha", Role.STAFF);
//        userService.save(user1);
//        userService.save(user);
//
//    }
}
