package dao;
import data.HistoriqueStatutCandidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueStatutCandidaturedao extends JpaRepository<HistoriqueStatutCandidature, Long>{

}
