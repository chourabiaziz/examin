package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.Beneficiaire;

@Repository
public interface BeneficiareRepository extends JpaRepository<Beneficiaire, Integer> {

}
