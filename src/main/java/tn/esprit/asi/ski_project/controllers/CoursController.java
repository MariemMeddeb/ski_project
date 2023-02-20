package tn.esprit.asi.ski_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.services.ICoursService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private ICoursService icoursService;

    @PostMapping
    public Cours add(@RequestBody Cours cours)
    {
        icoursService.add(cours);
        return cours;
    }

    @PutMapping
    public Cours update(@RequestBody Cours Cours)
    {
        return icoursService.update(Cours);
    }
    @GetMapping("/{id}")
    public Cours getCours(@PathVariable("id") Integer idCours)
    {
        return icoursService.getById(idCours);
    }
    @GetMapping
    public List<Cours> getAllCourss()
    {
        return icoursService.getAll();
    }
    @DeleteMapping("/{id}")
    void deleteCours(@PathVariable("id") Integer idCours)
    {
        icoursService.remove(idCours);
    }
}
