package esprit.tn.examin.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esprit.tn.examin.entity.Assurance;
import esprit.tn.examin.service.AssuranceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Gestion Assurance")
@RestController
@AllArgsConstructor
@RequestMapping("/assurance")
public class AssuranceController {

    AssuranceService assuranceService;

    @GetMapping("/")
    public List<Assurance> index() {
        return assuranceService.findAll();
    }

    @PostMapping("/add")
    public Assurance addEtudiant(@RequestBody Assurance assurance) {
        Assurance etudiant1 = assuranceService.add(assurance);
        return etudiant1;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        assuranceService.delete(id);

    }

    @PutMapping("/edit")
    public Assurance edit(@RequestBody Assurance assurance) {
        return assuranceService.edit(assurance);
    }

}
