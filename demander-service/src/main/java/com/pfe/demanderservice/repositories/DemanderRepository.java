package com.pfe.demanderservice.repositories;

import com.pfe.demanderservice.entities.Demander;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemanderRepository extends JpaRepository<Demander,Long> {
}
