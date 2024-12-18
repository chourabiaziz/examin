package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.Classe;
import esprit.tn.examin.entity.CoursClassroom;
import esprit.tn.examin.entity.Niveau;
import esprit.tn.examin.entity.Specialite;

public interface ICoursservice {

    List<CoursClassroom> findAll();

    CoursClassroom findById(int id);

    CoursClassroom add(CoursClassroom cours);

    void delete(int id);

    CoursClassroom edit(CoursClassroom cours);

    CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse);

    void desaffecterCoursClassroomClasse(Integer idCours);

    void archiverCoursClassrooms();

    Integer nbHeuresParSpecEtNiv(Specialite specialite, Niveau niveau);

}
