package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ServiceI<Reservation> {

    private final IReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAll() {
        log.info("Récupération de toutes les réservations");
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveById(Long id) {
        log.info("Récupération de la réservation id={}", id);
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable : id=" + id));
    }

    @Override
    public Reservation add(Reservation entity) {
        log.info("Ajout d'une nouvelle réservation");
        return reservationRepository.save(entity);
    }

    @Override
    public Reservation update(Reservation entity) {
        log.info("Mise à jour de la réservation id={}", entity.getIdReservation());
        return reservationRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        log.info("Suppression de la réservation id={}", id);
        reservationRepository.deleteById(id);
    }
}