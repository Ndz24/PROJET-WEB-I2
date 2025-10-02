package dao;
import data.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Documentdao extends JpaRepository<Document, Long> {

}