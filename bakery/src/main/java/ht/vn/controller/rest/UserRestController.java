package ht.vn.controller.rest;


import ht.vn.model.Role;
import ht.vn.model.Status;
import ht.vn.model.User;
import ht.vn.service.UserService;
import ht.vn.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    UserService userService;

    @Autowired
    private AppUtil appUtil;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/create")
    public ModelAndView showUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-user");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView doCreatePage(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-user");
        modelAndView.addObject("users", new User());
        user.setStatus(Status.ACTIVED);
        user.setRole(Role.USER);
        userService.save(user);

        return modelAndView;
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@PathVariable @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }
        Long id = user.getId();

        Optional<User> optionalUser = userService.findById(id);

//        userService.save(user);
        if (optionalUser.isPresent()) {
            userService.save(user);
            Optional<User> updateUser = userService.findById(id);
            return new ResponseEntity<>(updateUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error for update customer", HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/delete")
//    public ResponseEntity<?> doDelete(@RequestBody User user) {
//        Optional<User> optionalUser = userService.findById(user.getId());
//        if (optionalUser.isPresent()) {
//            userService.softDelete(user);
//            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
//        } else {
//            throw new IllegalStateException("fgewb");
//        }
//    }
//
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> doDelete(@PathVariable Long userId) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            userService.softDelete(optionalUser.get());
            return new ResponseEntity<>("Delete customer successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error for delete customer", HttpStatus.BAD_REQUEST);
    }

}