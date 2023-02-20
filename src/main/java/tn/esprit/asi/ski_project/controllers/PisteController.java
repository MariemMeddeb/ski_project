package tn.esprit.asi.ski_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.services.IPisteService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteController {
    @Autowired
    private IPisteService pisteService;
    @PostMapping
    Piste addPiste(@RequestBody Piste Piste)
    {
        pisteService.add(Piste);
        return Piste;
    }

    @PutMapping
    Piste updatePiste(@RequestBody Piste piste)
    {
        return pisteService.update(piste);
    }
    @GetMapping("/{id}")
    Piste getPiste(@PathVariable("id") Integer idPiste)
    {
        return pisteService.getById(idPiste);
    }
    @GetMapping
    List<Piste> getAllPistes()
    {
        return pisteService.getAll();
    }
    @DeleteMapping("/{id}")
    void deletePiste(@PathVariable("id") Integer idPiste)
    {
        pisteService.remove(idPiste);
    }

}
