package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.DishDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service.DishService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishController {
    public final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/showAllDishesByEstablish")
    public Slice<DishDTO> showAllDishByEstabId(@RequestParam Long estabId, Pageable pageable){
        return dishService.showAllDishesByEstablId(estabId, pageable);
    }
}
