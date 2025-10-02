package dao;
import data.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entreprisedao extends JpaRepository<Entreprise, Long> {

}
