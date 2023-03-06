package tn.esprit.asi.ski_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.services.IAbonnementService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

    //    http://localhost:9090/abonnement
    @Autowired
    private IAbonnementService iAbonnementService;

    @PostMapping
    public void add(@RequestBody Abonnement a) {
        iAbonnementService.add(a);
    }

    @PutMapping
    public Abonnement update(@RequestBody Abonnement a) {
        return iAbonnementService.update(a);
    }
    @GetMapping
    public List<Abonnement> getAll() {
        return iAbonnementService.getAll();    }
    @GetMapping("/{id}")
    public Abonnement getById(@PathVariable long id) {
        return  iAbonnementService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        iAbonnementService.remove(id);
    }

    public Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement){
        return iAbonnementService.findByTypeAbon(typeAbonnement);}

}
