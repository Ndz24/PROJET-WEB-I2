package data;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String chemin; // chemin fichier

    @ManyToOne(optional = false)
    private Candidature candidature;

    @ManyToOne(optional = false)
    private RefTypeDocument refTypeDocument;
}
