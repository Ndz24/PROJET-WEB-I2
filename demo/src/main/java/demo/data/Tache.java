// Renommé en Tache.java
package data;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "taches")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime dateEcheance;

    private boolean terminee;

    @ManyToOne(optional = false)
    private Candidature candidature;

    @ManyToOne(optional = false)
    private RefTypeTache refTypeTache;
}
