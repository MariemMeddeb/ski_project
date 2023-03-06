package tn.esprit.asi.ski_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.services.ISkieurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skieur")

public class SkieurController {
    @Autowired
    private ISkieurService skieurService;
    @PostMapping
    Skieur addSkieur(@RequestBody Skieur skieur)
    {
         skieurService.add(skieur);
        return skieur;
    }

    @PutMapping
    Skieur updateSkieur(@RequestBody Skieur skieur)
    {
        return skieurService.update(skieur);
    }
    @GetMapping("/{id}")
    Skieur getSkieur(@PathVariable("id") Integer idskieur)
    {
        return skieurService.getById(idskieur);
    }
    @GetMapping
    List<Skieur> getAllSkieurs()
    {
        return skieurService.getAll();
    }
    @DeleteMapping("/{id}")
    void deleteSkieur(@PathVariable("id") Integer idSkieur)
    {
        skieurService.remove(idSkieur);
    }
    @PutMapping("/{numSkieur}/{numPiste}")
    Skieur assignSkierToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste){
        return skieurService.assignSkierToPiste(numSkieur,numPiste);
    }
    @PutMapping("/abonSk/{numSkieur}/{numAbon}")
    Skieur assignSkierToAbonnement(@PathVariable Long numSkieur,@PathVariable Long numAbon){
        return skieurService.assignSkierToAbonnement(numSkieur,numAbon);
    }
  // public Skieur addSkierAndAssignToCourse(Skieur skieur,Long numCourse) {
  //     return skieurService.addSkierAndAssignToCourse(skieur,numCourse);
  // }

    @GetMapping("/skAbon/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement) {
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }


}
