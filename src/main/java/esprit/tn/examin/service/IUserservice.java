package esprit.tn.examin.service;

import java.util.List;

import esprit.tn.examin.entity.User;

public interface IUserservice {
    List<User> findAll();

    User findById(int id);

    User add(User classe);

    void delete(int id);

    User edit(User classe);

    void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse);
}
