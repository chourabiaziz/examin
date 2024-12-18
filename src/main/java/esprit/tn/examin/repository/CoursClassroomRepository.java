package esprit.tn.examin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import esprit.tn.examin.entity.CoursClassroom;
import esprit.tn.examin.entity.Niveau;
import esprit.tn.examin.entity.Specialite;

@Repository
public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {

    @Query("SELECT SUM(c.nbHeure) FROM CoursClassroom c WHERE c.specialite = :specialite AND c.classe.niveau = :niveau")
    Integer findTotalHeuresBySpecialiteAndNiveau(@Param("specialite") Specialite specialite,
            @Param("niveau") Niveau niveau);

}
