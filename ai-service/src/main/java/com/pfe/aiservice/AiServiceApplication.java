package com.pfe.aiservice;

import com.pfe.aiservice.entities.Matching;
import com.pfe.aiservice.repositories.MatchingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//@EnableDiscoveryClient
public class AiServiceApplication {
    private final MatchingRepository matchingRepository;

    public AiServiceApplication(MatchingRepository matchingRepository) {
        this.matchingRepository = matchingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AiServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AiServiceApplication aiServiceApplication) {
        return args -> {
            Matching M1 = Matching.builder()
                    .donorId(1L)
                    .demanderId(1L)
                    .score(0.8)
                    .build();
            matchingRepository.save(M1);

            Matching M2 = Matching.builder()
                    .donorId(4L)
                    .demanderId(3L)
                    .score(4.8)
                    .build();
            matchingRepository.save(M2);
            Matching D3 = Matching.builder()
                    .donorId(3L)
                    .demanderId(5L)
                    .score(2.8)
                    .build();
            matchingRepository.save(D3);

            Matching m = matchingRepository.findById(2L).get();
            System.out.println("Match de " + m.getDonorId() + "/" + m.getDemanderId());


        };
    }
}