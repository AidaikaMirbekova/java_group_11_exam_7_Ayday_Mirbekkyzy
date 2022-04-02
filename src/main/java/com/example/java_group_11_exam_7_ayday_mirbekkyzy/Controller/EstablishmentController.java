package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Controller;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.DTO.EstablishmentDTO;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Service.EstablishmentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {
    private final EstablishmentService establishmentService;

    public EstablishmentController(EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @GetMapping("/showAllEstablishments")
    public Slice<EstablishmentDTO> showAllEstablishment( Pageable pageable){
        return establishmentService.showAllEstablishment(pageable);
    }


}
