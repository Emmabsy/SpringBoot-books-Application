package com.emma.bookz.service;

import com.emma.bookz.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long productId);
    Product updateProduct(Product product, long productId);
    void deleteProduct(long productId);

}
