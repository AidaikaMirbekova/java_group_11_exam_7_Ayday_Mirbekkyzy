package com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Dish;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DishDTO {

    public static DishDTO from(Dish dish){
        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .type(dish.getType())
                .establishmentId(dish.getEstablish().getId())
                .price(dish.getPrice())
                .build();
    }

    Long id;
    String name;
    String type;
    Long establishmentId;
    Integer price;


}
