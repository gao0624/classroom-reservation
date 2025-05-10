package com.mango.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Table {
    private String id;
    private String classroom_id;
    private String name;

    public Table( String id, String classroom_id, String name){
        this.id = id;
        this.classroom_id = classroom_id;
        this.name = name;
    }
}
