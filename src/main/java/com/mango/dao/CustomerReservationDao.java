package com.mango.dao;

import com.mango.pojo.CustomerReservationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerReservationDao {
    List<CustomerReservationInfo> getAllCustomerReservationInfo();

    void addCustomerReservationInfo(CustomerReservationInfo customerReservationInfo);

}
