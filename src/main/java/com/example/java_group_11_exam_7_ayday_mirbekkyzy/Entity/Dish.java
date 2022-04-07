package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Utils.GenerateData;
import lombok.*;
import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dish {
    private static Random r =new Random();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_dish")
    String name;

    @Column(name = "type_dish")
    String type;

    @Column(name = "price")
    Integer price;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    Establishment establish;

    public static Dish random(Establishment establishment) {
        return builder()
                .name(GenerateData.randomDish().getName())
                .type(GenerateData.randomDish().getType())
                .price(r.nextInt(50))
                .establish(establishment)
                .build();
    }

}
