package com.pfe.aiservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Matching {
    @Id @GeneratedValue
    private Long id;
    private Long donorId;
    private Long demanderId;
    private Double score;
    private Boolean confirmed = false;
    private LocalDateTime dateCreated = LocalDateTime.now();
    // Getters/setters
}

