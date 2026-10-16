package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;
    private String libelle;

    // ⚠️ PAS de liste de Vehicule ici (relation unidirectionnelle gérée par Vehicule)
}
