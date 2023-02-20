package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Cours;

import java.util.List;

public interface ICoursService {
    void add(Cours c);
    Cours update(Cours c);
    List<Cours> getAll();
    Cours getById(long id);
    void remove(long id);
}
