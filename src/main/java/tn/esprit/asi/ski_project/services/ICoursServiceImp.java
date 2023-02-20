package tn.esprit.asi.ski_project.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.repositories.CoursRepository;

import java.util.List;
@Service
public class ICoursServiceImp implements ICoursService{
    @Autowired
    private CoursRepository CoursRepository ;
    @Override
    public void add(Cours c) {
        CoursRepository.save(c);
    }

    @Override
    public Cours update(Cours c) {
        return CoursRepository.save(c);
    }

    @Override
    public List<Cours> getAll() {
        return (List<Cours>) CoursRepository.findAll();
    }

    @Override
    public Cours getById(long id) {
        return CoursRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        CoursRepository.deleteById(id);
    }
}
