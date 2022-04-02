package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Utils.GenerateData;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client_table")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;

    public static Client random() {
        return builder()
                .name(GenerateData.randomPersonName())
                .email(GenerateData.randomEmail())
                .build();
    }
}
