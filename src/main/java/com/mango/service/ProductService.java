package com.mango.service;

import com.mango.pojo.Product;
import com.mango.pojo.Table;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProduct();
    String addProduct(Product product);
    String upProduct(Product product);
    String deleteProduct(String id);
}
