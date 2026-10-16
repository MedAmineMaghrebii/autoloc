package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final ServiceI<Paiement> paiementService;

    @GetMapping
    public List<Paiement> getAll() {
        return paiementService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Paiement getById(@PathVariable Long id) {
        return paiementService.retrieveById(id);
    }

    @PostMapping
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementService.add(paiement);
    }

    @PutMapping
    public Paiement update(@RequestBody Paiement paiement) {
        return paiementService.update(paiement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paiementService.remove(id);
    }
}