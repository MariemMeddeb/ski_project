package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeCours;
import tn.esprit.asi.ski_project.repositories.CoursRepository;
import tn.esprit.asi.ski_project.repositories.InscriptionRepository;
import tn.esprit.asi.ski_project.repositories.SkieurRepository;

import java.util.List;
@Service
public class IInscriptionServiceImp implements IInscriptionService{
    @Autowired
    private InscriptionRepository InscriptionRepository;
    private SkieurRepository skieurRepository;
    private CoursRepository coursRepository;
    @Override
    public void add(Inscription i) {
        InscriptionRepository.save(i);
    }

    @Override
    public Inscription update(Inscription i) {
        return InscriptionRepository.save(i);
    }

    @Override
    public List<Inscription> getAll() {
        return InscriptionRepository.findAll();
    }

    @Override
    public Inscription getById(long id) {
        return InscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        InscriptionRepository.deleteById(id);
    }

    //fonction page 20
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = coursRepository.findById(numCours).orElse(null);

        // Vérification de l'âge du skieur
        if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT && skieur.getAgeS() >= 18) {
            throw new IllegalArgumentException("Skieur is too old for a children's group course");
        } else if (cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE && skieur.getAgeS() < 18) {
            throw new IllegalArgumentException("Skieur is too young for an adult group course");
        }

        // Vérification du nombre de skieurs déjà inscrits pour un cours collectif
        if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {
            int nbInscriptions = cours.getInscriptions().size();
            if (nbInscriptions == 6) {
                throw new IllegalArgumentException("This group course is already full");
            }
        }

        // Affectation l'inscription au skieur et au cours
        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        // Enregistrement de l'inscription
        return InscriptionRepository.save(inscription);
    }
}
