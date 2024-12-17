package esprit.tn.examin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esprit.tn.examin.entity.Assurance;
import esprit.tn.examin.entity.Contrat;
import esprit.tn.examin.service.AssuranceService;
import esprit.tn.examin.service.ContratService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Gestion contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    ContratService assuranceService;

    @GetMapping("/")
    public List<Contrat> index() {
        return assuranceService.findAll();
    }

    @PostMapping("/add")
    public Contrat addEtudiant(@RequestBody Contrat assurance) {
        Contrat etudiant1 = assuranceService.add(assurance);
        return etudiant1;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        assuranceService.delete(id);

    }

    @PutMapping("/edit")
    public Contrat edit(@RequestBody Contrat assurance) {
        return assuranceService.edit(assurance);
    }

}
