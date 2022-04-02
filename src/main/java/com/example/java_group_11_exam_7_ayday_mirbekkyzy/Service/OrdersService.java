package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.OrdersDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Orders;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.ClientRepository;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.DishRepository;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ClientRepository clientRepository;
    private final DishRepository dishRepository;

    public OrdersDTO addOrder(Long clientId,Long dishId) throws Exception {
        var user = clientRepository.findClientById(clientId);
        var dish = dishRepository.findDishById(dishId);
        if (dishId==null){
            throw new Exception("Dish not found!");
        }
        var addOrder= Orders.builder()
                .client(user)
                .dish(dish)
                .dateAdded(LocalDateTime.now())
                .build();
        ordersRepository.save(addOrder);
        return OrdersDTO.from(addOrder);

    }

    public Slice<OrdersDTO> showClientOrders(Long clientId, Pageable pageable) throws Exception {
        var user = clientRepository.findClientById(clientId);
        var orders = ordersRepository.findAllByClientId(user.getId(),pageable);
        if (user==null){
            throw new Exception("Client not found!");
        }
        return orders.map(OrdersDTO::from);
    }

}
