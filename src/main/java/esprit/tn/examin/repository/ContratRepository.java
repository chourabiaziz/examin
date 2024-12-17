package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

}
