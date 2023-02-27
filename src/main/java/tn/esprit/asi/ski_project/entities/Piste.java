package tn.esprit.asi.ski_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;
    private int longeur;
    private int pente;
    private Couleur couleur;

    @ManyToMany(mappedBy = "pistes")
    @JsonIgnore
    private Set<Skieur> skieurs;
}
