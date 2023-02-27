package tn.esprit.asi.ski_project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    @OneToMany
    private Set<Cours> cours;
}
