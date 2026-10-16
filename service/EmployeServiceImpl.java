package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeServiceImpl implements ServiceI<Employe> {

    private final IEmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAll() {
        log.info("Récupération de tous les employés");
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public Employe retrieveById(Long id) {
        log.info("Récupération de l'employé id={}", id);
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe introuvable : id=" + id));
    }

    @Override
    public Employe add(Employe entity) {
        log.info("Ajout d'un nouvel employé : {} {}", entity.getNom(), entity.getPrenom());
        return employeRepository.save(entity);
    }

    @Override
    public Employe update(Employe entity) {
        log.info("Mise à jour de l'employé id={}", entity.getIdEmploye());
        return employeRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression de l'employé id={}", id);
        employeRepository.deleteById(id);
    }
}