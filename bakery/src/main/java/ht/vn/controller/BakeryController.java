package ht.vn.controller;

import ht.vn.model.Bakery;

import ht.vn.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bakerys")
public class BakeryController {

    @Autowired
    private BakeryService bakeryService;


    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bakery");

        List<Bakery> bakery = bakeryService.findAllActive();

        modelAndView.addObject("bakerys", bakery);

        return modelAndView;
    }

//    @GetMapping("/add-bakery")
//    public ModelAndView showCreatePage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("add-bakery");
//        modelAndView.addObject("bakery", new Bakery());
//        return modelAndView;
//    }
//
//
//
//    @PostMapping("/add-bakery")
//    public ModelAndView doCreatePage(@ModelAttribute Bakery bakery) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("add-bakery");
//        modelAndView.addObject("bakery", new Bakery());
//
//        bakeryService.save(bakery);
//
//        return modelAndView;
//    }
}
