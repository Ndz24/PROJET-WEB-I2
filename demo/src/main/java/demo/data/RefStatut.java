package data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ref_statut")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefStatut{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String description;
}
