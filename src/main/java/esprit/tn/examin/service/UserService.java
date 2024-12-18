package esprit.tn.examin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import esprit.tn.examin.entity.Classe;
import esprit.tn.examin.entity.User;
import esprit.tn.examin.repository.ClasseRepository;
import esprit.tn.examin.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserService implements IUserservice {
    UserRepository userRepo;
    private ClasseRepository classeRepository;

    @Override
    public User add(User assurance) {
        return userRepo.save(assurance);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);

    }

    @Override
    public User edit(User assurance) {
        return userRepo.save(assurance);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        // Fetch the user by ID
        User user = userRepo.findById(idUtilisateur)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + idUtilisateur));

        // Fetch the class by ID
        Classe classe = classeRepository.findById(codeClasse)
                .orElseThrow(() -> new RuntimeException("Class not found with code: " + codeClasse));

        // Set the class for the user
        user.setClasse(classe);

        // Save the updated user entity
        userRepo.save(user);
    }

}
