package com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Establishment;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EstablishmentDTO {
    public static EstablishmentDTO from(Establishment establishment) {
        return builder()
                .id(establishment.getId())
                .name(establishment.getName())
                .description(establishment.getDescription())
                .build();
    }

    Long id;
    String name;
    String description;

}
