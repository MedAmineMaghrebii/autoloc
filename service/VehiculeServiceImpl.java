package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehiculeServiceImpl implements ServiceI<Vehicule> {

    private final IVehiculeRepository vehiculeRepository;

    @Override
    public List<Vehicule> retrieveAll() {
        log.info("Récupération de tous les véhicules");
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveById(Long id) {
        log.info("Récupération du véhicule id={}", id);
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : id=" + id));
    }

    @Override
    public Vehicule add(Vehicule entity) {
        log.info("Ajout d'un nouveau véhicule : {}", entity.getImmatriculation());
        return vehiculeRepository.save(entity);
    }

    @Override
    public Vehicule update(Vehicule entity) {
        log.info("Mise à jour du véhicule id={}", entity.getIdVehicule());
        return vehiculeRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression du véhicule id={}", id);
        vehiculeRepository.deleteById(id);
    }
}