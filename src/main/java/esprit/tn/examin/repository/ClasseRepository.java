package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {

}
