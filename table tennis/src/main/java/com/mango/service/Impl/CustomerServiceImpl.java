package com.mango.service.Impl;

import com.mango.dao.CustomerReservationDao;
import com.mango.pojo.CustomerReservationInfo;
import com.mango.service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@Data
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerReservationDao CustomerReservationDao;

    @Override
    public List<CustomerReservationInfo> getAllCustomerReservationInfo(){
        return CustomerReservationDao.getAllCustomerReservationInfo();
    }

    @Override
    public String addCustomerReservationInfo(CustomerReservationInfo customerReservationInfo) {
        CustomerReservationDao.addCustomerReservationInfo(customerReservationInfo);
        return "ok";
    }

}
