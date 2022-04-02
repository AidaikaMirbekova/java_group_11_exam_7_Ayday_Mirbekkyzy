package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
   Client findClientById(Long clientId);
}
