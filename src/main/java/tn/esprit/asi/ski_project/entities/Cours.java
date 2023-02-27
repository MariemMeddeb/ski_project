package tn.esprit.asi.ski_project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;


}
