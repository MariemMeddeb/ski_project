package tn.esprit.asi.ski_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Moniteur;
import tn.esprit.asi.ski_project.services.IMoniteurService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {
    @Autowired
    private IMoniteurService moniteurService;
    @PostMapping
    Moniteur addMoniteur(@RequestBody Moniteur moniteur)
    {
        moniteurService.add(moniteur);
        return moniteur;
    }

    @PutMapping
    Moniteur updateMoniteur(@RequestBody Moniteur Moniteur)
    {
        return moniteurService.update(Moniteur);
    }
    @GetMapping("/{id}")
    Moniteur getMoniteur(@PathVariable("id") Integer idMoniteur)
    {
        return moniteurService.getById(idMoniteur);
    }
    @GetMapping
    List<Moniteur> getAllMoniteurs()
    {
        return moniteurService.getAll();
    }
    @DeleteMapping("/{id}")
    void deleteMoniteur(@PathVariable("id") Integer idMoniteur)
    {
        moniteurService.remove(idMoniteur);
    }
}
