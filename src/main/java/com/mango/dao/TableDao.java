package com.mango.dao;

import com.mango.pojo.CustomerReservationInfo;
import com.mango.pojo.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TableDao {
    List<Table> getAllTable();
    void addTable(Table table);
}
