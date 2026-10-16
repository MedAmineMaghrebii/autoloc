package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.enums.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;
    private BigDecimal montant;
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    // ⚠️ PAS de champ Contrat ici (relation unidirectionnelle gérée par Contrat)
}
