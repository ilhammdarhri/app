package com.pfe.donorservice;

import com.pfe.donorservice.entities.Donor;
import com.pfe.donorservice.repositories.DonorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient

public class DonorServiceApplication {

    private final DonorRepository DonorRepository;

    public DonorServiceApplication(DonorRepository DonorRepository) {
        this.DonorRepository = DonorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DonorServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(DonorServiceApplication donorServiceApplication)
    { return args -> {
        Donor D1=Donor.builder()
                .age(30)
                .nom("Sara")
                .ville("Rabat")
                .build();
        DonorRepository.save(D1);

        Donor D2=Donor.builder()
                .age(24)
                .nom("Hajar")
                .ville("Meknes")
                .build();
        DonorRepository.save(D2);
        Donor D3=Donor.builder()
                .age(19)
                .nom("Mohamed")
                .ville("Azrou")
                .build();
        DonorRepository.save(D3);

        Donor c =DonorRepository.findById(2L).get();
        System.out.println("Nom "+c.getNom());


    };

    }
}
