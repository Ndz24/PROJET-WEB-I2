package data;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages_email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet;

    @Lob
    private String contenu;

    private LocalDateTime dateEnvoi;

    @ManyToOne(optional = false)
    private Candidature candidature;
}
