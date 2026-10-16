package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final ServiceI<Agence> agenceService;

    @GetMapping
    public List<Agence> getAll() {
        return agenceService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Agence getById(@PathVariable Long id) {
        return agenceService.retrieveById(id);
    }

    @PostMapping
    public Agence create(@RequestBody Agence agence) {
        return agenceService.add(agence);
    }

    @PutMapping
    public Agence update(@RequestBody Agence agence) {
        return agenceService.update(agence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        agenceService.remove(id);
    }
}