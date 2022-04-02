package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Utils.GenerateData;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_dish")
    String name;

    @Column(name = "type_dish")
    String type;

    @Column(name = "price")
    Double price;

    public static Dish random() {
        return builder()
                .name(GenerateData.randomDish().toString())
                .type(GenerateData.randomDish().toString())
                .build();
    }
}
