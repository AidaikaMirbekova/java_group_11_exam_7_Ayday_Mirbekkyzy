package com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Orders;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrdersDTO {

    public static OrdersDTO from(Orders orders) {
        return builder()
                .id(orders.getId())
                .clientId(orders.getClient().getId())
                .dishId(orders.getDish().getId())
                .dateAdded(LocalDateTime.now())
                .build();
    }

    Long id;
    Long clientId;
    Long dishId;
    LocalDateTime dateAdded;
}
