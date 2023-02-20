package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.repositories.AbonnementRepository;

import java.util.List;

@Service //instance de la classe dans le spring context
public class IAbonnementServiceImp implements IAbonnementService{
    @Autowired //injecter les dependences pour tous les attributs
    private AbonnementRepository abonnementRepository ; //instantiation
    @Override
    public void add(Abonnement a) {
        //traitement
        abonnementRepository.save(a);
    }
    @Override
    public Abonnement update(Abonnement a) {

        return abonnementRepository.save(a);
    }

    @Override
    public List<Abonnement> getAll() {

        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement getById(long id) {

        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        abonnementRepository.deleteById(id);
    }
}