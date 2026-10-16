package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaintenanceServiceImpl implements ServiceI<Maintenance> {

    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> retrieveAll() {
        log.info("Récupération de toutes les maintenances");
        return (List<Maintenance>) maintenanceRepository.findAll();
    }

    @Override
    public Maintenance retrieveById(Long id) {
        log.info("Récupération de la maintenance id={}", id);
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance introuvable : id=" + id));
    }

    @Override
    public Maintenance add(Maintenance entity) {
        log.info("Ajout d'une nouvelle maintenance");
        return maintenanceRepository.save(entity);
    }

    @Override
    public Maintenance update(Maintenance entity) {
        log.info("Mise à jour de la maintenance id={}", entity.getIdMaintenance());
        return maintenanceRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression de la maintenance id={}", id);
        maintenanceRepository.deleteById(id);
    }
}