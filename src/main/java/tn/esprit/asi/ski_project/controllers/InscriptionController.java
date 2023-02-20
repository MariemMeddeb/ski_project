package tn.esprit.asi.ski_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.services.IInscriptionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inscription")
public class InscriptionController {
    @Autowired
    private IInscriptionService inscriptionService;
    @PostMapping
    Inscription addInscription(@RequestBody Inscription inscription)
    {
        inscriptionService.add(inscription);
        return inscription;
    }

    @PutMapping
    Inscription updateInscription(@RequestBody Inscription Inscription)
    {
        return inscriptionService.update(Inscription);
    }
    @GetMapping("/{id}")
    Inscription getInscription(@PathVariable("id") Integer idInscription)
    {
        return inscriptionService.getById(idInscription);
    }
    @GetMapping
    List<Inscription> getAllInscriptions()
    {
        return inscriptionService.getAll();
    }
    @DeleteMapping("/{id}")
    void deleteInscription(@PathVariable("id") Integer idInscription)
    {
        inscriptionService.remove(idInscription);
    }
}
