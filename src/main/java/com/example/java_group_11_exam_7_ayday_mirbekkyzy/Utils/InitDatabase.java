package com.example.java_group_11_exam_7_ayday_mirbekkyzy.Utils;

import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Client;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Dish;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Entity.Establishment;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.ClientRepository;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.DishRepository;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.EstablishmentRepository;
import com.example.java_group_11_exam_7_ayday_mirbekkyzy.Repository.OrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.generate;

@Configuration
public class InitDatabase {
    private static final Random rand = new Random();

    @Bean
    CommandLineRunner init(ClientRepository clientRepo,
                           DishRepository dishRepo,
                           EstablishmentRepository estabRepo,
                           OrdersRepository orderRepo) {
        return (args) -> {
            clientRepo.deleteAll();
            dishRepo.deleteAll();
            estabRepo.deleteAll();
            orderRepo.deleteAll();

            List<Client> clients = generate(Client::random)
                    .limit(300)
                    .collect(Collectors.toList());
            clientRepo.saveAll(clients);

            List<Establishment> establishments = generate(Establishment::random)
                    .limit(168)
                    .collect(Collectors.toList());
            estabRepo.saveAll(establishments);

            List<Dish> dishes = new ArrayList<>(38);

            establishments.forEach(establishment -> {
                selectEstab(establishments,+1).stream()
                        .map(establishment1 -> Dish.random(establishment))
                        .peek(dishes::add)
                        .forEach(dishRepo::save);
            });
        };
    }

    private static List<Establishment> selectEstab(List<Establishment> estab,int amount) {
        return Stream.generate(() -> getEstab(estab))
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }

    private static Establishment getEstab(List<Establishment> establishments) {
        return establishments.get(rand.nextInt(38));
    }
}
