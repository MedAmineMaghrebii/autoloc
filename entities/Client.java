package tn.esprit.autoloc.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    // BIDIRECTIONNELLE : Client <-> Reservation
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation r) {
        reservations.add(r);
        r.setClient(this);
    }
}
