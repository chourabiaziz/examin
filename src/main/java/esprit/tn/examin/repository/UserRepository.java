package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.Niveau;
import esprit.tn.examin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT COUNT(u) FROM User u WHERE u.classe.niveau = :niveau")
    Integer countUsersByNiveau(@Param("niveau") Niveau niveau);
}
