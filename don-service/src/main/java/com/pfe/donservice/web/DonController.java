package com.pfe.donservice.web;

import com.pfe.donservice.entities.Don;
import com.pfe.donservice.repositories.DonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DonController {

    public DonController(DonRepository donRepository) {
        this.donRepository = donRepository;
    }

    private DonRepository donRepository;


    @GetMapping("/GDon")
    public List<Don> allDon() {
        return donRepository.findAll();
    }
    @GetMapping("/GDon/{id}")
    public Don aDon(@PathVariable Long id){
        return  donRepository.findById(id).get();

    }
}

