package com.pfe.demandeservice;


import com.pfe.demandeservice.entities.Demande;
import com.pfe.demandeservice.repositories.DemandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//@EnableDiscoveryClient

public class DemandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemandeServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner debut(DemandeRepository demandeRepository){

        return args -> {

            Demande d1 =Demande.builder()
                    .intitule("PC Desktop")
                    .prix(4000.0)
                    .build();

            demandeRepository.save(d1);

            Demande d2=Demande.builder()
                    .intitule("PC Portable")
                    .prix(3000.0)
                    .build();

            demandeRepository.save(d2);

            Demande d3=Demande.builder()
                    .intitule("Imprimante ")
                    .prix(2000.0)
                    .build();

            demandeRepository.save(d3);

            System.out.println("=============");
            Demande d= demandeRepository.findById(1L).get();
            System.out.println("prix "+d.getPrix());

        };


    }
}
