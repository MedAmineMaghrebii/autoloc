package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final ServiceI<Maintenance> maintenanceService;

    @GetMapping
    public List<Maintenance> getAll() {
        return maintenanceService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return maintenanceService.retrieveById(id);
    }

    @PostMapping
    public Maintenance create(@RequestBody Maintenance maintenance) {
        return maintenanceService.add(maintenance);
    }

    @PutMapping
    public Maintenance update(@RequestBody Maintenance maintenance) {
        return maintenanceService.update(maintenance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        maintenanceService.remove(id);
    }
}