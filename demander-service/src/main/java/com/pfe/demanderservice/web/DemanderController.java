package com.pfe.demanderservice.web;

import com.pfe.demanderservice.entities.Demander;
import com.pfe.demanderservice.repositories.DemanderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class DemanderController {

    private final DemanderRepository demanderRepository;

    public DemanderController(DemanderRepository demanderRepository) {
        this.demanderRepository = demanderRepository;
    }

    DemanderRepository DemanderRepository;
    @GetMapping("/GDemanders")
    public List<Demander> allDemanders(){
        return demanderRepository.findAll();
    }


    @GetMapping("/GDemanders/{id}")
    public Demander aDemander(@PathVariable  Long id){
        return demanderRepository.findById(id).get();
    }
    @PostMapping("/PDemanders")
    public ResponseEntity<Demander> createDemander(@RequestBody Demander demander) {
        try {
            Demander savedDemander = demanderRepository.save(demander);
            return ResponseEntity.ok(savedDemander);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("UDemanders/{id}")
    public ResponseEntity<Demander> updateDemander(@PathVariable Long id, @RequestBody Demander demanderDetails) {
        try {
            Optional<Demander> optionalDemander = demanderRepository.findById(id);
            if (optionalDemander.isPresent()) {
                Demander demander = optionalDemander.get();
                demander.setNom(demanderDetails.getNom());
                demander.setAge(demanderDetails.getAge());
                demander.setVille(demanderDetails.getVille());
                Demander updatedDemander = demanderRepository.save(demander);
                return ResponseEntity.ok(updatedDemander);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("DDemanders/{id}")
    public ResponseEntity<Void> deleteDemander(@PathVariable Long id) {
        try {
            if (demanderRepository.existsById(id)) {
                demanderRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
