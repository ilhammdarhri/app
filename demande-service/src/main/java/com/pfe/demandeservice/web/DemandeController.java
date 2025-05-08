package com.pfe.demandeservice.web;

import com.pfe.demandeservice.entities.Demande;
import com.pfe.demandeservice.repositories.DemandeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DemandeController {

    public DemandeController(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    private DemandeRepository demandeRepository;


    @GetMapping("/GDemande")
    public List<Demande> allDemande() {
        return demandeRepository.findAll();
    }
    @GetMapping("/GDemande/{id}")
    public Demande aDemande(@PathVariable Long id){
        return  demandeRepository.findById(id).get();

    }
}
