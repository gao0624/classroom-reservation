package com.mango.service;

import com.mango.pojo.Table;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {
    List<Table> getAllTable();
    String addTable(Table table);
}
