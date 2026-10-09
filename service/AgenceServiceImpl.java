package tn.esprit.autoloc.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgenceServiceImpl implements ServiceI<Agence> {

    private final IAgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAll() {
        log.info("Récupération de toutes les agences");
        return (List<Agence>) agenceRepository.findAll();
    }

    @Override
    public Agence retrieveById(Long id) {
        log.info("Récupération de l'agence id={}", id);
        return agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : id=" + id));
    }

    @Override
    public Agence add(Agence entity) {
        log.info("Ajout d'une nouvelle agence : {}", entity.getNom());
        return agenceRepository.save(entity);
    }

    @Override
    public Agence update(Agence entity) {
        // On vérifie que l'entité existe bien avant de faire un merge
        if (entity.getIdAgence() == null || !agenceRepository.existsById(entity.getIdAgence())) {
            throw new RuntimeException("Mise à jour impossible : agence inexistante");
        }
        log.info("Mise à jour de l'agence id={}", entity.getIdAgence());
        return agenceRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new RuntimeException("Suppression impossible : agence inexistante id=" + id);
        }
        log.info("Suppression de l'agence id={}", id);
        // Cascade ALL + orphanRemoval sur vehicules et employes -> nettoyage automatique
        agenceRepository.deleteById(id);
    }
}