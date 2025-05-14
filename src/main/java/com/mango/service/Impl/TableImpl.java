package com.mango.service.Impl;

import com.mango.dao.TableDao;
import com.mango.pojo.Table;
import com.mango.service.TableService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TableImpl implements TableService {

    @Autowired
    TableDao TableDao;

    @Override
    public List<Table> getAllTable(){
        return TableDao.getAllTable();
    }

    @Override
    public String addTable(Table table){
        TableDao.addTable(table);
        return "ok";
    }

    @Override
    public void deleteTable(String id){
        TableDao.deleteTable(id);
    }
}
