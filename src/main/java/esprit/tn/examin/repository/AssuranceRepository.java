package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.Assurance;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {

}
