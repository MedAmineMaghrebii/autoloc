package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipementServiceImpl implements ServiceI<Equipement> {

    private final IEquipementRepository equipementRepository;

    @Override
    public List<Equipement> retrieveAll() {
        log.info("Récupération de tous les équipements");
        return (List<Equipement>) equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveById(Long id) {
        log.info("Récupération de l'équipement id={}", id);
        return equipementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable : id=" + id));
    }

    @Override
    public Equipement add(Equipement entity) {
        log.info("Ajout d'un nouvel équipement : {}", entity.getLibelle());
        return equipementRepository.save(entity);
    }

    @Override
    public Equipement update(Equipement entity) {
        log.info("Mise à jour de l'équipement id={}", entity.getIdEquipement());
        return equipementRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression de l'équipement id={}", id);
        equipementRepository.deleteById(id);
    }
}