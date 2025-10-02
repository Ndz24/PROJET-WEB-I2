package dao;
import data.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tachedao extends JpaRepository<Tache, Long>{

}
