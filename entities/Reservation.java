package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.enums.StatutReservation;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // BIDIRECTIONNELLE : Reservation -> Client (propriétaire)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // BIDIRECTIONNELLE : Reservation -> Vehicule (propriétaire)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    // BIDIRECTIONNELLE : Reservation <-> Contrat
    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contrat contrat;

    // Helper pour synchroniser les deux côtés
    public void setContrat(Contrat c) {
        this.contrat = c;
        if (c != null) c.setReservation(this);
    }











}
