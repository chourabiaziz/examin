package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.Assurance;

public interface IAssurance {
    List<Assurance> findAll();

    Assurance findById(int id);

    Assurance add(Assurance assurance);

    void delete(int id);

    Assurance edit(Assurance assurance);
}
