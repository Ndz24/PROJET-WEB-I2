package dao;
import data.MessageEmail;
import data.MessageEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagaeEmaildao extends JpaRepository<MessageEmail, Long>{

}
