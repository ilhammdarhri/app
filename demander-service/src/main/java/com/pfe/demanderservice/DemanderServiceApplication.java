package com.pfe.demanderservice;

import com.pfe.demanderservice.entities.Demander;
import com.pfe.demanderservice.repositories.DemanderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient

public class DemanderServiceApplication {

    private final DemanderRepository DemanderRepository;

    public DemanderServiceApplication(DemanderRepository DemanderRepository) {
        this.DemanderRepository = DemanderRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemanderServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(DemanderServiceApplication demanderServiceApplication)
    { return args -> {
        Demander D1=Demander.builder()
                .age(20)
                .nom("Aya")
                .ville("Rabat")
                .build();
        DemanderRepository.save(D1);

        Demander D2=Demander.builder()
                .age(24)
                .nom("Lamin")
                .ville("fes")
                .build();
        DemanderRepository.save(D2);
        Demander D3=Demander.builder()
                .age(19)
                .nom("Moha")
                .ville("Sale")
                .build();
        DemanderRepository.save(D3);

        Demander d =DemanderRepository.findById(2L).get();
        System.out.println("Nom "+d.getNom());


    };

    }
}
