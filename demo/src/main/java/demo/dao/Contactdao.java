package dao;

import data.Candidature;
import data.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Contactdao extends JpaRepository<Contact,Long> {
}
