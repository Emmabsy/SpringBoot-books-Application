package com.emma.bookz.controller;

import com.emma.bookz.model.Product;
import com.emma.bookz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/vi")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //build create product rest api
    @PostMapping("/products")
        public ResponseEntity<Product> saveProduct (@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
        //return productService.saveProduct(product);
    }
    //build get all employees rest api
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

}
