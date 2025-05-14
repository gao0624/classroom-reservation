package com.mango.service.Impl;

import com.mango.dao.ProductDao;
import com.mango.dao.TableDao;
import com.mango.pojo.Product;
import com.mango.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAllProduct(){
        return productDao.getAllProduct();
    }
    @Override
    public String addProduct(Product product){
        productDao.addProduct(product);
        return "ok";
    }
    @Override
    public String upProduct(Product product){
        productDao.upProduct(product);
        return "ok";
    }
    @Override
    public String deleteProduct(String id){
        productDao.deleteProduct(id);
        return "ok";
    }
}
