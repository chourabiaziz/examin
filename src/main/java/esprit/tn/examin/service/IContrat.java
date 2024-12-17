package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.Beneficiaire;
import esprit.tn.examin.entity.Contrat;

public interface IContrat {

    List<Contrat> findAll();

    Contrat findById(int id);

    Contrat add(Contrat contrat);

    void delete(int id);

    Contrat edit(Contrat contrat);
}
