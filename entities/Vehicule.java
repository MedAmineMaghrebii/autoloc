package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.enums.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // BIDIRECTIONNELLE : Vehicule -> Agence (côté propriétaire)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // UNIDIRECTIONNELLE : Vehicule -> Maintenance
    // Le Vehicule est propriétaire de la relation, la Maintenance n'a PAS de champ Vehicule
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "vehicule_id")   // clé étrangère dans la table maintenance
    private List<Maintenance> maintenances = new ArrayList<>();

    // UNIDIRECTIONNELLE : Vehicule -> Equipement (ManyToMany)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private Set<Equipement> equipements = new HashSet<>();

    // BIDIRECTIONNELLE : Vehicule <-> Reservation
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    // Helpers
    public void addReservation(Reservation r) {
        reservations.add(r);
        r.setVehicule(this);
    }
    public void addMaintenance(Maintenance m) {
        maintenances.add(m);
    }
}
