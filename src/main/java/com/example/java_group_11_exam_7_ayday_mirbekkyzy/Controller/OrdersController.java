package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    public final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<String> addOrder(@RequestParam Long clientId, Long dishId) throws Exception {
        ordersService.addOrder(clientId, dishId);
        return ResponseEntity.ok().build();
    }
}
