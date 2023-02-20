package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.repositories.InscriptionRepository;

import java.util.List;
@Service
public class IInscriptionServiceImp implements IInscriptionService{
    @Autowired
    private InscriptionRepository InscriptionRepository;
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
}
