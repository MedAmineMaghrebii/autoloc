package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContratServiceImpl implements ServiceI<Contrat> {

    private final IContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAll() {
        log.info("Récupération de tous les contrats");
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat retrieveById(Long id) {
        log.info("Récupération du contrat id={}", id);
        return contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable : id=" + id));
    }

    @Override
    public Contrat add(Contrat entity) {
        log.info("Ajout d'un nouveau contrat");
        return contratRepository.save(entity);
    }

    @Override
    public Contrat update(Contrat entity) {
        log.info("Mise à jour du contrat id={}", entity.getIdContrat());
        return contratRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression du contrat id={}", id);
        contratRepository.deleteById(id);
    }
}