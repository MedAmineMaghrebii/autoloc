package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    // ⚠️ PAS de champ Vehicule ici !
    // La relation est gérée uniquement par @JoinColumn côté Vehicule.
}

