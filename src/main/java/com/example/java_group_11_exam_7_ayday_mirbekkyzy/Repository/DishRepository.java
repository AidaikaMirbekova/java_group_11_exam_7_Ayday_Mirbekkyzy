package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Dish;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface DishRepository extends PagingAndSortingRepository<Dish,Long> {

    Slice<Dish> findDishesByEstabId(Long estabId, Pageable pageable);
    Dish findDishById(Long dishId);

}
