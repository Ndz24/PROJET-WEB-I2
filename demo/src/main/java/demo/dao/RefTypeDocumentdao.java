package dao;
import data.RefTypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefTypeDocumentdao extends JpaRepository<RefTypeDocument, Long>{

}
