package com.mango.api;

import com.mango.pojo.Classroom;
import com.mango.pojo.CustomerReservationInfo;
import com.mango.pojo.Table;
import com.mango.service.Impl.ClassroomServiceImpl;
import com.mango.service.Impl.CustomerServiceImpl;
import com.mango.service.Impl.TableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerReservationAPI {
    @Autowired
    CustomerServiceImpl customer;

    @Autowired
    TableImpl tableImpl;

    @Autowired
    ClassroomServiceImpl classroomService;

    @GetMapping("/api/auth/reservation")
    public List<CustomerReservationInfo> check() {
        //查询所有的订阅信息
        System.out.println("走到这里了吗");
        List<CustomerReservationInfo> list  = customer.getAllCustomerReservationInfo();
        System.out.println(list);
        return list;
    }

    @GetMapping("/api/auth/getAllTable")
    public List<Table> getTable(){
        List<Table> list = tableImpl.getAllTable();
        return list;
    }

    @GetMapping("/api/auth/all_shop")
    public List<Classroom> all_classroom() {
        List<Classroom> classrooms = classroomService.getAll();
        System.out.println(classrooms);

        return classrooms;
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
        customerReservationInfo.setState("预约成功");
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        customerReservationInfo.setReservation_time(currentTime.format(formatter));
        System.out.println(customerReservationInfo);
        String if_ = customer.addCustomerReservationInfo(customerReservationInfo);
        return if_;
    }

    @PostMapping("/api/auth/addReservation2")
    public String add(@RequestParam("name") String name,
                      @RequestParam("phone") String phone,
                      @RequestParam("shop_name") String shop_name,
                      @RequestParam("hall_name") String hall_name,
                      @RequestParam("table_number") String table_number,
                      @RequestParam("start_end_time") String start_end_time,
                      @RequestParam("state") String state
                      ){
        CustomerReservationInfo customerReservationInfo = new CustomerReservationInfo();
        System.out.println(name);
        customerReservationInfo.setName(name);
        customerReservationInfo.setPhone(phone);
        customerReservationInfo.setShop_name(shop_name);
        customerReservationInfo.setHall_name(hall_name);
        customerReservationInfo.setTable_number(table_number);
        customerReservationInfo.setStart_end_time(start_end_time);
        customerReservationInfo.setState(state);
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        customerReservationInfo.setReservation_time(currentTime.format(formatter));
        System.out.println(customerReservationInfo);
        String if_ = customer.addCustomerReservationInfo(customerReservationInfo);
        return if_;
    }
}
