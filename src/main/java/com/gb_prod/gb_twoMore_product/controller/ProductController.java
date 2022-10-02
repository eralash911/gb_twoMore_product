package com.gb_prod.gb_twoMore_product.controller;

import com.gb_prod.gb_twoMore_product.repository.ProductRepository;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@SpringBootApplication
@Controller
@RequestMapping("/product")
public class ProductController {
//    private final static Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);

    private ProductRepository repository;
    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public String idPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", repository.findById(id));
        return "product-form";
    }

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("product", repository.findAll());
        return "product";

    }
}
