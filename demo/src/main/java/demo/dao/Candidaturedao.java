package dao;

import data.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Candidaturedao extends JpaRepository<Candidature, Long> {
}
