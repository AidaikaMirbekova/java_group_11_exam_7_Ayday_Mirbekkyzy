package com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Client;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class CLientDTO {
    public static CLientDTO from (Client client) {
        return builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();

    }
    Long id;
    String name;
    String email;
}
