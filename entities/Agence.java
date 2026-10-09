package tn.esprit.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    // BIDIRECTIONNELLE : Agence -> Vehicule
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicule> vehicules = new ArrayList<>();

    // BIDIRECTIONNELLE : Agence -> Employe
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employe> employes = new ArrayList<>();

    // Helper methods pour maintenir la cohérence
    public void addVehicule(Vehicule v) {
        vehicules.add(v);
        v.setAgence(this);
    }
    public void removeVehicule(Vehicule v) {
        vehicules.remove(v);
        v.setAgence(null);
    }
    public void addEmploye(Employe e) {
        employes.add(e);
        e.setAgence(this);
    }
}
