package com.pfe.donorservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Donor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonor;
    private String nom;
    private Integer age;
    private String ville;
}
