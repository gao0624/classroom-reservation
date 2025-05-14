package com.mango.api;

import com.mango.pojo.CustomerReservationInfo;
import com.mango.pojo.Product;
import com.mango.pojo.Student;
import com.mango.service.Impl.BlackListServiceImpl;
import com.mango.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductControllerApi {
    @Autowired
    ProductService productService;

    @GetMapping("/api/auth/productList")
    public List<Product> productList() {
        List<Product> list  = productService.getAllProduct();
        System.out.println();
        return list;
    }

    @PostMapping("/api/auth/addProduct")
    public String add(@RequestParam("id") String id,
                      @RequestParam("name") String name,
                      @RequestParam("price") Double price,
                      @RequestParam("image") String image,
                      @RequestParam("description") String description){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setImage(image);
        product.setDescription(description);
        String mess = productService.addProduct(product);
        return mess;
    }

    @PostMapping("/api/auth/upProduct")
    public String up(@RequestParam("id") String id,
                     @RequestParam("name") String name,
                     @RequestParam("price") Double price,
                     @RequestParam("image") String image,
                     @RequestParam("description") String description){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setImage(image);
        product.setDescription(description);
        String mess = productService.upProduct(product);
        return mess;

    }

    @PostMapping("/api/auth/deleteProduct")
    public String delete(@RequestParam("id") String id){
        System.out.println("执行到这里了吗");
        String mess = productService.deleteProduct(id);
        return mess;
    }
}
