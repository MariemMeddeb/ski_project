package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Skieur;

import java.util.List;

public interface ISkieurService {
    void add(Skieur s);
    Skieur update(Skieur s);
    List<Skieur> getAll();
    Skieur getById(long id);
    void remove(long id);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur assignAbonnementToSkier(Long numSkieur, Long numAbon);
}
