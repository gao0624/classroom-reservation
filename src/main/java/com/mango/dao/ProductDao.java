package com.mango.dao;

import com.mango.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDao {
    List<Product> getAllProduct();
    void addProduct(Product product);
    void upProduct(Product product);
    void deleteProduct(String id);
}
