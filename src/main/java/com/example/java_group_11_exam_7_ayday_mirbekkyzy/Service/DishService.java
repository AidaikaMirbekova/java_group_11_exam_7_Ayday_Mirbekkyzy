package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.DishDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DishService {

    private final DishRepository dishRepository;

    public Slice<DishDTO> showAllDishesByEstablId(Long estabId, Pageable pageable){
        var allDish = dishRepository.findAllByEstablishId(estabId,pageable);
        return allDish.map(DishDTO::from);
    }

}
