package com.pfe.demandeservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;
    private String intitule;
    private Double prix;


}