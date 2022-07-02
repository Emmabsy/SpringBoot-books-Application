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
    @PostMapping()
        public ResponseEntity<Product> saveProduct (@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
        //return productService.saveProduct(product);

    }
    //build get all products rest api
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }
    //build get product by id REST API
    //http://localhost:8080/api/v1/1
    @GetMapping("{productId}")
    public ResponseEntity<Product>getProductById(@PathVariable("productId") long productId){
        return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
    }
    //Build update employee rest api
    //http://localhost:8080/api/v1/1
    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId")long productId,
                                                 @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, productId), HttpStatus.OK);
    }

        //build delete REST API
        @DeleteMapping("{productId}")
        public ResponseEntity<String> deleteProduct(@PathVariable("productId")long productId){

            //delete employee from database
           productService.deleteProduct(productId);

            return new ResponseEntity<String>("Product deleted sucessfully", HttpStatus.OK);


    }

}
