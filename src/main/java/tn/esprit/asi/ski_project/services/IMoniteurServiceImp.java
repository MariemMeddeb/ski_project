package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Moniteur;
import tn.esprit.asi.ski_project.repositories.MoniteurRepository;

import java.util.List;
@Service
public class IMoniteurServiceImp implements IMoniteurService{
    @Autowired
    private MoniteurRepository MoniteurRepository;
    @Override
    public void add(Moniteur m) {
        MoniteurRepository.save(m);
    }

    @Override
    public Moniteur update(Moniteur m) {
        return MoniteurRepository.save(m);
    }

    @Override
    public List<Moniteur> getAll() {
        return MoniteurRepository.findAll();
    }

    @Override
    public Moniteur getById(long id) {
        return MoniteurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        MoniteurRepository.deleteById(id);
    }
}
