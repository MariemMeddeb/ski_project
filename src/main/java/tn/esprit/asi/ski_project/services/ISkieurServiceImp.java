package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.asi.ski_project.entities.*;
import tn.esprit.asi.ski_project.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ISkieurServiceImp implements ISkieurService{

    @Autowired
    private SkieurRepository skieurRepository;
    @Autowired
    private PisteRepository pisteRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Override
    public void add(Skieur s) {
        skieurRepository.save(s);
    }

    @Override
    public Skieur update(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> getAll() {

        return skieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        skieurRepository.deleteById(id);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) { //ki naamel assign nestaamlou "set"
        //recuperation des objets
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        //verifier si skieur not null
        Assert.notNull(skieur,"skieur not found");
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        //verifier si piste not null
        Assert.notNull(piste,"piste not found");
        //traitement n7eb nsety les objets l gdom jebtah w zedtah lgdim w ba3ed lgdim m3a jdid n7otah f ligne lekher "skieur.setPistes(pistes);"
   /* Set<Piste> pistes = skieur.getPistes();
    pistes.add(piste);
    skieur.setPistes(pistes);
    */
        skieur.getPistes().add(piste); //njib mel skieur liste des pistes puis najoutiw l piste ellio l Id mte3ha numPiste
        //save
        return  skieurRepository.save(skieur);
    }


    @Override
    public Skieur assignSkierToAbonnement(Long numSkieur, Long numAbon) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur,"skieur not found");
        Abonnement abonnement = abonnementRepository.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement not found");
        skieur.setAbonnement(abonnement);
        return skieurRepository.save(skieur);
    }
    @Override
     public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }

    @Override
    public Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement) {
        return abonnementRepository.findByTypeAbon(typeAbonnement);
    }

    //  @Override
 //  public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
 //      List<Skieur> list = new ArrayList<>();
 //      for (Skieur s:getAll()) {
 //          if (s.getAbonnement().getTypeAbon().equals(typeAbonnement)) {
 //              list.add(s);
 //          }
 //      }
 //      return list;
 //  }

    // @Override
 // public Skieur addSkierAndAssignToCourse(Skieur skieur,Long numCours, Long numInscription) {
 //     Cours cours = coursRepository.findById(numCours).orElse(null);
 //     Inscription inscription = inscriptionRepository.findById(numInscription).orElse(null);
 //     if(cours!=null && inscription!=null){ add(skieur);}
 //     List<Inscription> inscriptions = new ArrayList<Inscription>();
 //     coursList.add(cours);
 //     cours.setInscriptions(inscriptions);

 //     return null;
 // }
}
