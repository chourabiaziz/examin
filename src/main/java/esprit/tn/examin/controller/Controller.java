package esprit.tn.examin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import esprit.tn.examin.entity.Classe;
import esprit.tn.examin.entity.CoursClassroom;
import esprit.tn.examin.entity.Niveau;
import esprit.tn.examin.entity.Specialite;
import esprit.tn.examin.entity.User;
import esprit.tn.examin.service.Classservice;
import esprit.tn.examin.service.Coursserivce;
import esprit.tn.examin.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Welcome")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final UserService userservice;
    private final Coursserivce coursserivce;
    private final Classservice classservice;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userservice.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userservice.add(user);
    }

    @PostMapping("/classes")
    public Classe addClasse(@RequestBody Classe classe) {
        return classservice.add(classe);
    }

    @PostMapping("/courses")
    public CoursClassroom addCoursClassroom(@RequestBody CoursClassroom cours) {
        return coursserivce.add(cours);
    }

    @PostMapping("/courses/{codeClasse}")
    public CoursClassroom addCoursToClass(@RequestBody CoursClassroom cours, @PathVariable Integer codeClasse) {
        return coursserivce.ajouterCoursClassroom(cours, codeClasse);
    }

    @PutMapping("/users/{idUtilisateur}/classes/{codeClasse}")
    public ResponseEntity<Void> assignUserToClass(@PathVariable Integer idUtilisateur,
            @PathVariable Integer codeClasse) {
        userservice.affecterUtilisateurClasse(idUtilisateur, codeClasse);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/courses/{idCours}/remove")
    public ResponseEntity<Void> removeCoursFromClass(@PathVariable Integer idCours) {
        coursserivce.desaffecterCoursClassroomClasse(idCours);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hours/{specialite}/{niveau}")
    public Integer getHoursBySpecialiteAndNiveau(@PathVariable Specialite specialite, @PathVariable Niveau niveau) {
        return coursserivce.nbHeuresParSpecEtNiv(specialite, niveau);
    }
}
