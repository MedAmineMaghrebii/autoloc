package tn.esprit.autoloc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(
            mappedBy = "agence",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vehicule> vehicules = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "agence",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Employe> employes = new ArrayList<>();

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