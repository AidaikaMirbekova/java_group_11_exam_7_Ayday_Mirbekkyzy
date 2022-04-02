package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Utils.GenerateData;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "establishment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_instablishment")
    String name;

    @Column(name = "description")
    String description;

    public static Establishment random() {
        return builder()
                .name(GenerateData.randomPlace().toString())
                .description(GenerateData.randomPlace().toString())
                .build();
    }
}