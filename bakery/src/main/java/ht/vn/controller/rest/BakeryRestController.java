package ht.vn.controller.rest;


import ht.vn.model.Bakery;
import ht.vn.model.BakeryForm;
import ht.vn.model.User;
import ht.vn.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/bakerys")

public class BakeryRestController {

    @Autowired
    private BakeryService bakeryService;

    //    private final String folderUpload = "/upload/";
//    private final String uploadLocal = "/Users/thuanho/Desktop/C0921G1/product4/bakery/src/main/webapp/upload/";
    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/{id}")
    public ResponseEntity<Bakery> getById(@PathVariable Long id) {
        Optional<Bakery> bakery = bakeryService.findById(id);
        if (bakery.isPresent()) {
            return new ResponseEntity<>(bakery.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreatePage(BakeryForm bakeryForm) {
        MultipartFile multipartFile = bakeryForm.getImage();

        String extension = multipartFile.getOriginalFilename();

        int result = extension.indexOf(".");
        String result1 = extension.substring(result);


        String fileName = UUID.randomUUID().toString()  + result1;
        try {
            FileCopyUtils.copy(bakeryForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        Bakery bakery = new Bakery(bakeryForm.getBakeryName(), bakeryForm.getPrice(), bakeryForm.getQuantity(), bakeryForm.getDescription(), fileName);
//        Bakery bakery1 = new Bakery(0L, "bakeryForm.getName()", BigDecimal.valueOf(12), BigDecimal.valueOf(2), bakeryForm.getDescription(), fileName);
        bakeryService.save(bakery);
//        ModelAndView modelAndView = new ModelAndView("/add-bakery");
//        modelAndView.addObject("bakeryForm", bakeryForm);
//        modelAndView.addObject("bakery", new Bakery());
//        modelAndView.addObject("message", "Created new product successfully !");
        return new ResponseEntity<>("Oke", HttpStatus.OK);
    }

    @DeleteMapping("/{bakeryId}")
    public ResponseEntity<?> doDelete(@PathVariable Long bakeryId) {
        Optional<Bakery> optionalBakery = bakeryService.findById(bakeryId);
        if (optionalBakery.isPresent()) {
            bakeryService.softDelete(optionalBakery.get());
            return new ResponseEntity<>("Delete bakery successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error for delete customer", HttpStatus.BAD_REQUEST);
    }
//    @PostMapping("/update")
//    public ResponseEntity<?> doUpdatePage(BakeryForm bakeryForm) {
//        MultipartFile multipartFile = bakeryForm.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(bakeryForm.getImage().getBytes(), new File(fileUpload + fileName));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Bakery bakery = new Bakery(bakeryForm.getBakeryName(), bakeryForm.getPrice(), bakeryForm.getQuantity(), bakeryForm.getDescription(), fileName);
//        bakeryService.save(bakery);
//
//        return new ResponseEntity<>("Oke", HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@RequestBody Bakery bakery) {
        Long id = bakery.getId();
//        System.out.println(id);
        Optional<Bakery> optionalBakery = bakeryService.findById(id);
        bakeryService.save(bakery);
        if (optionalBakery.isPresent()) {
            bakeryService.save(bakery);
            Optional<Bakery> updateBakery = bakeryService.findById(id);
            return new ResponseEntity<>(updateBakery.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error for update customer", HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/update")
//    public ResponseEntity<?> doUpdate( BakeryForm bakeryForm) {
//        Long id = bakeryForm.getId();
//        System.out.println(id);
//        Optional<BakeryForm> optionalBakeryForm = bakeryService.findById(id);
//        bakeryService.save(bakeryForm);
//        if (optionalBakeryForm.isPresent()) {
//            bakeryService.save(bakeryForm);
//            Optional<BakeryForm> updateUser = bakeryService.findById(id);
//            return new ResponseEntity<>(updateUser.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Error for update customer", HttpStatus.BAD_REQUEST);
//        }
//    }

//
//    @PostMapping("/create")
//    public ModelAndView doCreatePage(@ModelAttribute Bakery bakery) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("add-bakery");
//        modelAndView.addObject("bakery", new Bakery());
//
//        bakeryService.save(bakery);
//
//        return modelAndView;
//    }

//    @PostMapping("/create")
//    public ModelAndView doCreatePage(@RequestBody BakeryForm bakeryForm) {
//        MultipartFile multipartFile = bakeryForm.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(bakeryForm.getImage().getBytes(), new File(fileUpload + fileName));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//
//        }
//        Bakery bakery = new Bakery(bakeryForm.getBakeryName(), bakeryForm.getPrice(), bakeryForm.getQuantity(), bakeryForm.getDescription(), fileName);
////        Bakery bakery1 = new Bakery(0L, "bakeryForm.getName()", BigDecimal.valueOf(12), BigDecimal.valueOf(2), bakeryForm.getDescription(), fileName);
//        bakeryService.save(bakery);
//        ModelAndView modelAndView = new ModelAndView("/add-bakery");
//        modelAndView.addObject("bakeryForm", bakeryForm);
//        modelAndView.addObject("bakery", new Bakery());
//        modelAndView.addObject("message", "Created new product successfully !");
//        return modelAndView;
//    }

//    @PostMapping("/create")
//    public ModelAndView doCreate(@ModelAttribute("bakery") Bakery bakery, HttpServletRequest request, @ModelAttribute("bakeryForm") BakeryForm bakeryForm) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("/add-bakery");
//
//        String uploadRootPath = request.getServletContext().getRealPath(folderUpload);
//
//        File uploadRootDir = new File(uploadRootPath);
//        if (!uploadRootDir.exists()) {
//            uploadRootDir.mkdir();
//        }
//
//        MultipartFile multipartFile = bakeryForm.getImage();
//        String fileName = multipartFile.getOriginalFilename();
//
//        try {
//            File serverFile = new File(uploadRootPath + fileName);
//            File localFile = new File(uploadLocal + fileName);
//
//            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//            stream.write(multipartFile.getBytes());
//            stream.close();
//
//            BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(localFile));
//            streamLocal.write(multipartFile.getBytes());
//            streamLocal.close();
//
//            bakery.setImage(fileName);
//            bakeryService.save(bakery);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        modelAndView.addObject("bakery", new Bakery());
//        modelAndView.addObject("bakeryForm", new BakeryForm());
//
////        List<CategoryGroup> categoryGroups = categoryGroupService.findAll();
////        modelAndView.addObject("categoryGroups", categoryGroups);
//
//        return modelAndView;
//    }


}
