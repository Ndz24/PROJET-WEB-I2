package dao;
import data.RefStatut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefStatutdao extends JpaRepository<RefStatut, Long>{

}
