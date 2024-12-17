package esprit.tn.examin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Contrat;
import esprit.tn.examin.repository.ContratRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ContratService implements IContrat {
    ContratRepository contratRepository;

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat findById(int id) {
        return contratRepository.findById(id).get();
    }

    @Override
    public Contrat add(Contrat contrat) {

        return contratRepository.save(contrat);
    }

    @Override
    public void delete(int id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat edit(Contrat contrat) {
        return contratRepository.save(contrat);
    }

}
