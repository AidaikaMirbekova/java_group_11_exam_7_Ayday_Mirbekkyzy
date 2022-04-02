package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

    Slice<Orders> findAllByClientId(Long clientId, Pageable pageable);
}
