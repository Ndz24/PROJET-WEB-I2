package dao;
import data.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Utilisateurdao extends JpaRepository<Utilisateur, Long>{

}
