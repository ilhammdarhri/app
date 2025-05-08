package com.pfe.donorservice.repositories;

import com.pfe.donorservice.entities.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor,Long> {
}