package com.mango.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerReservationInfo {
    private String name;
    private String phone;
    private String shop_name;
    private String hall_name;
    private String table_number;
    private String start_end_time;
    private String reservation_time;
    private String state;

    public CustomerReservationInfo(
            String name,
            String phone,
            String shop_name,
            String hall_name,
            String table_number,
            String start_end_time,
            String reservation_time,
            String state){
        this.name = name;
        this.phone = phone;
        this.shop_name = shop_name;
        this.hall_name = hall_name;
        this.table_number = table_number;
        this.start_end_time = start_end_time;
        this.reservation_time = reservation_time;
        this.state = state;
    }
}
