package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final ServiceI<Contrat> contratService;

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Contrat getById(@PathVariable Long id) {
        return contratService.retrieveById(id);
    }

    @PostMapping
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.add(contrat);
    }

    @PutMapping
    public Contrat update(@RequestBody Contrat contrat) {
        return contratService.update(contrat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratService.remove(id);
    }
}