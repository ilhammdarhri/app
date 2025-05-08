package com.pfe.donservice;

import com.pfe.donservice.entities.Don;
import com.pfe.donservice.repositories.DonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//@EnableDiscoveryClient

public class DonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner debut(DonRepository donRepository){

        return args -> {

            Don d1 =Don.builder()
                    .intitule("PC Desktop")
                    .prix(4000.0)
                    .build();

            donRepository.save(d1);

            Don d2=Don.builder()
                    .intitule("PC Portable")
                    .prix(3000.0)
                    .build();

           donRepository.save(d2);

            Don d3=Don.builder()
                    .intitule("Imprimante ")
                    .prix(2000.0)
                    .build();

           donRepository.save(d3);

            System.out.println("=============");
            Don d= donRepository.findById(1L).get();
            System.out.println("prix "+d.getPrix());

        };


    }
}
