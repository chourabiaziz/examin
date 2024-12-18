package esprit.tn.examin.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursClassroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCours;
    private Specialite specialite;
    private String nom;
    private int nbHeure;
    private boolean archive;

    @ManyToOne
    @JsonBackReference
    Classe classe;

}
