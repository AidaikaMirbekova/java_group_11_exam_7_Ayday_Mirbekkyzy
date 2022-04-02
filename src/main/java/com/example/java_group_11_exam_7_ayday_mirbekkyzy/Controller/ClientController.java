package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.OrdersDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service.OrdersService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    public final OrdersService ordersService;

    public ClientController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/showClientOrders")
    public Slice<OrdersDTO> showAllOrdersByClientId(@RequestParam Long clientId, Pageable pageable) throws Exception {
        return ordersService.showClientOrders(clientId,pageable);
    }
}
