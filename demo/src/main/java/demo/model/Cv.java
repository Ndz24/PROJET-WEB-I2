package demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cvs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String job;
    private String date;
    private String etat;

    // Pour le fichier PDF (optionnel)
    @Lob
    private byte[] data;

    private String nomFichier;
    private String type;
}
