package dao;

import data.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Entretiendao extends JpaRepository<Entretien, Long> {
}
