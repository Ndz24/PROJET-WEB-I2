package data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ref_type_tache")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefTypeTache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code; // ex: RELANCE, SUIVI, APPEL

    private String description;
}
