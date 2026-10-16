package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.service.ServiceI;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final ServiceI<Employe> employeService;

    @GetMapping
    public List<Employe> getAll() {
        return employeService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Employe getById(@PathVariable Long id) {
        return employeService.retrieveById(id);
    }

    @PostMapping
    public Employe create(@RequestBody Employe employe) {
        return employeService.add(employe);
    }

    @PutMapping
    public Employe update(@RequestBody Employe employe) {
        return employeService.update(employe);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeService.remove(id);
    }
}