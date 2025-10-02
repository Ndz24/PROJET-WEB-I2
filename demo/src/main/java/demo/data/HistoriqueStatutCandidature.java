package data;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historique_statut_candidature")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriqueStatutCandidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateChangement;

    private String commentaire;

    @ManyToOne(optional = false)
    private Candidature candidature;

    @ManyToOne(optional = false)
    private RefStatut refStatut;
}
