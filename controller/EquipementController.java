package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final ServiceI<Equipement> equipementService;

    @GetMapping
    public List<Equipement> getAll() {
        return equipementService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Equipement getById(@PathVariable Long id) {
        return equipementService.retrieveById(id);
    }

    @PostMapping
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.add(equipement);
    }

    @PutMapping
    public Equipement update(@RequestBody Equipement equipement) {
        return equipementService.update(equipement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipementService.remove(id);
    }
}