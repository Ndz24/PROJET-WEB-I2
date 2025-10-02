package data;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ref_type_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefTypeDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code; // ex: CV, LM, PORTFOLIO

    private String description;
}
