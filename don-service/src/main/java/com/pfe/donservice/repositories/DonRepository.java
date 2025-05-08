package com.pfe.donservice.repositories;

import com.pfe.donservice.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource
public interface DonRepository extends JpaRepository<Don,Long> {
}
