package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.Classe;

public interface IClasseservice {

    List<Classe> findAll();

    Classe findById(int id);

    Classe add(Classe classe);

    void delete(int id);

    Classe edit(Classe classe);
}
