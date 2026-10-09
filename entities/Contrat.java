package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private Boolean valide;

    // BIDIRECTIONNELLE : Contrat -> Reservation (côté propriétaire)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", unique = true)
    private Reservation reservation;

    // UNIDIRECTIONNELLE : Contrat -> Paiement
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contrat_id")   // FK dans la table paiement
    private List<Paiement> paiements = new ArrayList<>();

    public void addPaiement(Paiement p) {
        paiements.add(p);
    }
}
