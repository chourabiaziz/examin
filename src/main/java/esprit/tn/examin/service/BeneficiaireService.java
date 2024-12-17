package esprit.tn.examin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Beneficiaire;
import esprit.tn.examin.repository.BeneficiareRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class BeneficiaireService implements IBeneficiare {
    BeneficiareRepository beneficiareRepository;

    @Override
    public List<Beneficiaire> findAll() {
        return beneficiareRepository.findAll();
    }

    @Override
    public Beneficiaire findById(int id) {
        return beneficiareRepository.findById(id).get();
    }

    @Override
    public Beneficiaire add(Beneficiaire beneficiaire) {
        return beneficiareRepository.save(beneficiaire);
    }

    @Override
    public void delete(Beneficiaire beneficiaire) {
        beneficiareRepository.delete(beneficiaire);
    }

    @Override
    public Beneficiaire edit(Beneficiaire beneficiaire) {
        return beneficiareRepository.save(beneficiaire);
    }

}
