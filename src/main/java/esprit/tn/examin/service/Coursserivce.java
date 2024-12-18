package esprit.tn.examin.service;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Classe;
import esprit.tn.examin.entity.CoursClassroom;
import esprit.tn.examin.entity.Niveau;
import esprit.tn.examin.entity.Specialite;
import esprit.tn.examin.repository.CoursClassroomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Coursserivce implements ICoursservice {

    CoursClassroomRepository coursRepo;
    Classservice classservice;

    @Override
    public CoursClassroom add(CoursClassroom assurance) {
        return coursRepo.save(assurance);
    }

    @Override
    public void delete(int id) {
        coursRepo.deleteById(id);

    }

    @Override
    public CoursClassroom edit(CoursClassroom assurance) {
        return coursRepo.save(assurance);
    }

    @Override
    public List<CoursClassroom> findAll() {
        return coursRepo.findAll();
    }

    @Override
    public CoursClassroom findById(int id) {
        return coursRepo.findById(id).get();
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        // Fetch the associated Classe entity
        Classe classe = classservice.findById(codeClasse);
        // Associate the CoursClassroom with the Classe
        cc.setClasse(classe);

        // Save the CoursClassroom entity
        return coursRepo.save(cc);
    }

    @Override
    @Transactional
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cours = coursRepo.findById(idCours)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + idCours));

        cours.setClasse(null);
        coursRepo.save(cours);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    @Transactional
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursClassrooms = coursRepo.findAll();
        for (CoursClassroom cours : coursClassrooms) {
            cours.setArchive(true);
        }
        coursRepo.saveAll(coursClassrooms);
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite specialite, Niveau niveau) {
        return coursRepo.findTotalHeuresBySpecialiteAndNiveau(specialite, niveau);
    }
}