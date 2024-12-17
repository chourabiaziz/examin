package esprit.tn.examin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Assurance;
import esprit.tn.examin.repository.AssuranceRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class AssuranceService implements IAssurance {
    AssuranceRepository assuranceRepository;

    @Override
    public Assurance add(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    public void delete(int id) {
        assuranceRepository.deleteById(id);

    }

    @Override
    public Assurance edit(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    @Override
    public List<Assurance> findAll() {
        return assuranceRepository.findAll();
    }

    @Override
    public Assurance findById(int id) {
        return assuranceRepository.findById(id).get();
    }

}
