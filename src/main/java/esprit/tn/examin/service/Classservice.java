package esprit.tn.examin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Classe;
import esprit.tn.examin.repository.ClasseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Classservice implements IClasseservice {
    ClasseRepository classeRepository;

    @Override
    public Classe add(Classe assurance) {
        return classeRepository.save(assurance);
    }

    @Override
    public void delete(int id) {
        classeRepository.deleteById(id);

    }

    @Override
    public Classe edit(Classe assurance) {
        return classeRepository.save(assurance);
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    @Override
    public Classe findById(int id) {
        return classeRepository.findById(id).get();
    }

}