package com.mango.service;

import com.mango.pojo.CustomerReservationInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    List<CustomerReservationInfo> getAllCustomerReservationInfo();
    String addCustomerReservationInfo(CustomerReservationInfo customerReservationInfo);
}
