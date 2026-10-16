package tn.esprit.autoloc.entities;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.enums.RoleEmploye;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    // BIDIRECTIONNELLE : Employe -> Agence (côté propriétaire)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;
}
