package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.repositories.PisteRepository;

import java.util.List;
@Service
public class IPisteServiceImp implements IPisteService{
    @Autowired
    private PisteRepository PisteRepository;
    @Override
    public void add(Piste p) {
        PisteRepository.save(p);
    }

    @Override
    public Piste update(Piste p)
    {
        return PisteRepository.save(p);
    }

    @Override
    public List<Piste> getAll() {

        return PisteRepository.findAll();
    }

    @Override
    public Piste getById(long id) {

        return PisteRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        PisteRepository.deleteById(id);
    }
}
