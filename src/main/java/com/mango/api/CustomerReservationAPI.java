package com.mango.api;

import com.mango.pojo.CustomerReservationInfo;
import com.mango.service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerReservationAPI {
    @Autowired
    CustomerServiceImpl customer;

    @GetMapping("/api/auth/reservation")
    public List<CustomerReservationInfo> check() {
        //查询所有的订阅信息
        System.out.println("走到这里了吗");
        List<CustomerReservationInfo> list  = customer.getAllCustomerReservationInfo();
        System.out.println(list);
        return list;
    }

    @PostMapping("/api/auth/addReservation")
    public String add(@RequestParam("name") String name,
                      @RequestParam("phone") String phone,
                      @RequestParam("shop_name") String shop_name,
                      @RequestParam("hall_name") String hall_name,
                      @RequestParam("table_number") String table_number,
                      @RequestParam("start_end_time") String start_end_time
                      ){
        CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo();
        System.out.println(name);
        customerReservationInfo.setName(name);
        customerReservationInfo.setPhone(phone);
        customerReservationInfo.setShop_name(shop_name);
        customerReservationInfo.setHall_name(hall_name);
        customerReservationInfo.setTable_number(table_number);
        customerReservationInfo.setStart_end_time(start_end_time);
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        customerReservationInfo.setReservation_time(currentTime.format(formatter));
        System.out.println(customerReservationInfo);
        String if_ = customer.addCustomerReservationInfo(customerReservationInfo);
        return if_;
    }
}
