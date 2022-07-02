package com.emma.bookz.service.impl;

import com.emma.bookz.exception.ResourceNotFoundException;
import com.emma.bookz.model.Product;
import com.emma.bookz.repository.ProductRepository;
import com.emma.bookz.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

//@Auto
    public ProductServiceImpl(ProductRepository productRepository) {
        //super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        Optional<Product> product=productRepository.findById(productId);
        if(product.isPresent()){
            return product.get();
        }else{
            throw new ResourceNotFoundException("Product", "ID",productId);
        }
    }

}
