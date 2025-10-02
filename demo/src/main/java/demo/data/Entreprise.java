package data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "entreprise", schema = "ProjetWebI2")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Entreprise {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nom;

    private String domaine;
    private String siteWeb;
    private String linkedinUrl;
    private String secteur;
    private String taille;
    private String adresse;
    private String ville;
    private String pays;
    private String siret;

    //@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    //private List<Contact> contacts = new ArrayList<>();

    //@OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    //private List<Candidature> candidatures = new ArrayList<>();
}
