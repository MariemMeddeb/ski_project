package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.entities.TypeCours;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement); //select * from Skieur

    @Query(value = "SELECT * FROM skieur s JOIN abonnement a ON s.abonnement_num_abon = a.num_abon WHERE a.type_abon = typeabonnn", nativeQuery = true)
    List<Skieur> findByAbonnementTypeAbonTTypeSQL(@Param("typeabonnn") TypeAbonnement typeAbonnement); //SQL

    @Query(value = "SELECT s FROM Skieur s WHERE s.abonnement.typeAbon = :typeabonnn")
    List<Skieur> findByAbonnementTypeAbonTypeJPQL(@Param("typeabonnn") TypeAbonnement typeAbonnement); //JPQL

    List<Skieur>findByInscriptionsCoursTypeCours(TypeCours typeCours);

    @Query(value = "SELECT * FROM skieur s ORDER BY (SELECT COUNT * FROM inscription WHERE i.skieur_num_skieur = s.num_skieur)", nativeQuery = true)
    List<Skieur>OrderByNbrInscription();

    @Query(value = "SELECT s FROM skieur s ORDER BY s.inscriptions.size" , nativeQuery = true)
    List<Skieur> OrderbynbrinscripJPQL();
    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN inscription i on i.skieur_num_skieur = s.num_skieur" +
            "JOIN cours c on c.num_cours = i.cours_num_cours" +
            "JOIN moniteur_cours mc ON mc.cours_num_cours = c.num_cours" +
            "JOIN moniteur m on m.num_moniteur = mc.moniteur_num_moniteur" +
            "WHERE m.prenomm = :prenom", nativeQuery = true)
    List<Skieur>ListeSkieurParCoursParMoniteur(@Param("prenom") String prenom);

    @Query("SELECT s FROM Skieur s JOIN Inscription i ON s.numSkieur = i.skieur.numSkieur JOIN Moniteur m ON i.cours member of m.cours WHERE m.nomM = :prenom")
    List<Skieur>ListeSkieurParCoursParMoniteurJPQL(@Param("prenom") String prenom);
}
