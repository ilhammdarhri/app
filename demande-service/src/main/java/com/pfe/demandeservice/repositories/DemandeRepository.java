package com.pfe.demandeservice.repositories;

import com.pfe.demandeservice.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<Demande,Long> {
}