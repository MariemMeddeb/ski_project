package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.repositories.AbonnementRepository;
import tn.esprit.asi.ski_project.repositories.PisteRepository;
import tn.esprit.asi.ski_project.repositories.SkieurRepository;

import java.util.List;

@Service
public class ISkieurServiceImp implements ISkieurService{

    @Autowired
    private SkieurRepository skieurRepository;
    @Autowired
    private PisteRepository pisteRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
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
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
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
        skieur.getPistes().add(piste);
        //save
        return  skieurRepository.save(skieur);
    }
    @Override
    public Skieur assignAbonnementToSkier(Long numSkieur, Long numAbon) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Assert.notNull(skieur,"skieur not found");
        Abonnement abonnement = abonnementRepository.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement not found");
        skieur.setAbonnement(abonnement);


        return skieurRepository.save(skieur);
    }
}
