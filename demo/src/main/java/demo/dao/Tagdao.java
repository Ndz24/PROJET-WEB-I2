package dao;
import data.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tagdao extends JpaRepository<Tagdao, Long>{

}
