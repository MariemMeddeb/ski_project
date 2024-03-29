package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    Set<Abonnement> findByTypeAbonOrderByDateDebut(TypeAbonnement typeAbonnement);
    Set<Abonnement> findByDateDebutBetween(LocalDate dateDebut, LocalDate dateFin);

}
