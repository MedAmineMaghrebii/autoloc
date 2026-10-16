package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaiementServiceImpl implements ServiceI<Paiement> {

    private final IPaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAll() {
        log.info("Récupération de tous les paiements");
        return (List<Paiement>) paiementRepository.findAll();
    }

    @Override
    public Paiement retrieveById(Long id) {
        log.info("Récupération du paiement id={}", id);
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement introuvable : id=" + id));
    }

    @Override
    public Paiement add(Paiement entity) {
        log.info("Ajout d'un nouveau paiement");
        return paiementRepository.save(entity);
    }

    @Override
    public Paiement update(Paiement entity) {
        log.info("Mise à jour du paiement id={}", entity.getIdPaiement());
        return paiementRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression du paiement id={}", id);
        paiementRepository.deleteById(id);
    }
}