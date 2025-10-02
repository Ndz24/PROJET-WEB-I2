package data;


import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
//@Table(name = "candidature", schema = "")

public class Candidature {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_id")
    //private RefStatut statut;

    @Column(name = "intitule_poste", nullable = false)
    private String intitulePoste;

    private String localisation;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "type_contrat")
//    // private RefTypeContrat typeContrat;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "mode_travail")
    // private RefModeTravail modeTravail;

    // private String source;
    // private String urlOffre;
    // private String referenceOffre;
    // private Double salaireMin;
    // private Double salaireMax;
    // private String devise;

    // private Date dateDebutSouhaitee;

    // private Integer priorite = 0;
    // private Integer probabilite;

    // private Instant dernierEmailLe;
    // private Instant prochaineActionLe;
    // private String prochaineActionNote;

    // private boolean archive = false;

//     // private Instant creeLe = Instant.now();
//     // private Instant majLe = Instant.now();

//     @ManyToMany
//     @JoinTable(
//         name = "candidature_tag",
//         schema = "ProjetWebI2",
//         joinColumns = @JoinColumn(name = "candidature_id"),
//         inverseJoinColumns = @JoinColumn(name = "tag_id")
//     )
//     private Set<Tag> tags = new HashSet<>();

//     @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL)
//     private List<Document> documents = new ArrayList<>();

//     @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL)
//     private List<Tache> taches = new ArrayList<>();

//     @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL)
//     private List<Entretien> entretiens = new ArrayList<>();

//     @OneToMany(mappedBy = "candidature", cascade = CascadeType.ALL)
//     private List<MessageEmail> emails = new ArrayList<>();
}
