package com.mango.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product{
    private String id;
    private String name;
    private Double price;
    private String image;
    private String description;

    public Product(String id, String name, Double price, String image, String description){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }


}