package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.EstablishmentDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    public Slice<EstablishmentDTO> showAllEstablishment(Pageable pageable){
        var allEstab = establishmentRepository.findAll(pageable);
        return allEstab.map(EstablishmentDTO::from);
    }
}
