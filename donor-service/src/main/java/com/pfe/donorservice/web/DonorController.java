package com.pfe.donorservice.web;

import com.pfe.donorservice.entities.Donor;
import com.pfe.donorservice.repositories.DonorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class DonorController {

    public DonorController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }
    private final DonorRepository donorRepository;

    @GetMapping("/GDonors")
    public List<Donor> allDonors() {
        return donorRepository.findAll();
    }

    @GetMapping("/GDonors/{id}")
    public ResponseEntity<Donor> aDonor(@PathVariable Long id) {
        return donorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/PDonors")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        try {
            Donor savedDonor = donorRepository.save(donor);
            return ResponseEntity.ok(savedDonor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("UDonors/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor donorDetails) {
        try {
            Optional<Donor> optionalDonor = donorRepository.findById(id);
            if (optionalDonor.isPresent()) {
                Donor donor = optionalDonor.get();
                donor.setNom(donorDetails.getNom());
                donor.setAge(donorDetails.getAge());
                donor.setVille(donorDetails.getVille());
                Donor updatedDonor = donorRepository.save(donor);
                return ResponseEntity.ok(updatedDonor);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("DDonors/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        try {
            if (donorRepository.existsById(id)) {
                donorRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }



}