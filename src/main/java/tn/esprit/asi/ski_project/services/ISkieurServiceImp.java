package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.repositories.SkieurRepository;

import java.util.List;

@Service
public class ISkieurServiceImp implements ISkieurService{

    @Autowired
    private SkieurRepository SkieurRepository;
    @Override
    public void add(Skieur s) {
        SkieurRepository.save(s);
    }

    @Override
    public Skieur update(Skieur s) {
        return SkieurRepository.save(s);
    }

    @Override
    public List<Skieur> getAll() {

        return SkieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return SkieurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        SkieurRepository.deleteById(id);
    }
}
