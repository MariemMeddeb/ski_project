package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.asi.ski_project.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
