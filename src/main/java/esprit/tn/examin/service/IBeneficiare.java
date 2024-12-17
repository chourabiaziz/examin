package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.Beneficiaire;

public interface IBeneficiare {
    List<Beneficiaire> findAll();

    Beneficiaire findById(int id);

    Beneficiaire add(Beneficiaire beneficiaire);

    void delete(Beneficiaire beneficiaire);

    Beneficiaire edit(Beneficiaire beneficiaire);
}
