package com.pfe.aiservice.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.pfe.aiservice.entities.Matching;
import com.pfe.aiservice.repositories.MatchingRepository;
import org.springframework.stereotype.Service;

@RestController
@RequestMapping
@Service
public class MatchingController {

    private final MatchingRepository matchingRepository;

    public MatchingController(MatchingRepository matchingRepository) {
        this.matchingRepository = matchingRepository;
    }
    @GetMapping("/GAi")
    public List<Matching> allMatches(){
        return matchingRepository.findAll();
    }


    @GetMapping("/GAi/{id}")
    public Matching aMatch(@PathVariable Long id){
        return matchingRepository.findById(id).get();
    }
    @PostMapping("/PAi")
    public ResponseEntity<Matching> createMatch(@RequestBody Matching matching) {
        try {
            Matching savedMatching = matchingRepository.save(matching);
            return ResponseEntity.ok(savedMatching);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("UAi/{id}")
    public ResponseEntity<Matching> updateMatching(@PathVariable Long id, @RequestBody Matching matchingDetails) {
        try {
            Optional<Matching> optionalMatching = matchingRepository.findById(id);
                    if (optionalMatching.isPresent()) {
                        Matching matching = optionalMatching.get();
                        matching.setDonorId(matchingDetails.getDonorId());
                        matching.setDemanderId(matchingDetails.getDemanderId());
                        matching.setConfirmed(matchingDetails.getConfirmed());
                        matching.setScore(matchingDetails.getScore());
                        matching.setDateCreated(matchingDetails.getDateCreated());
                        Matching updatedMatching = matchingRepository.save(matching);
                        return ResponseEntity.ok(updatedMatching);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("DAi/{id}")
    public ResponseEntity<Void> deleteMatching(@PathVariable Long id) {
        try {
            if (matchingRepository.existsById(id)) {
                matchingRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
