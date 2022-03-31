//package ht.vn.controller.rest;
//
//import ht.vn.model.Bakery;
//import ht.vn.model.BakeryForm;
//import ht.vn.service.BakeryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/bakery")
//@PropertySource("classpath:upload_file.properties")
//public class BakeryApi {
//
//    @Autowired
//    private BakeryService bakeryService;
//
//    @Value("${file-upload}")
//    private String fileUpload;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> doCreatePage(BakeryForm bakeryForm) {
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
////        ModelAndView modelAndView = new ModelAndView("/add-bakery");
////        modelAndView.addObject("bakeryForm", bakeryForm);
////        modelAndView.addObject("bakery", new Bakery());
////        modelAndView.addObject("message", "Created new product successfully !");
//        return new ResponseEntity<>("Oke", HttpStatus.OK);
//    }
//}
