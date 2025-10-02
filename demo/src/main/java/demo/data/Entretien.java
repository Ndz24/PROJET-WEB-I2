// Renommé en Entretien.java
package data;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entretiens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateEntretien;

    private String lieu;

    private String commentaire;

    @ManyToOne(optional = false)
    private Candidature candidature;

    @ManyToOne
    private Contact contact;
}
