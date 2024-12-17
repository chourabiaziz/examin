reop:

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>

service:

@Service
@AllArgsConstructor

public class EtudiantService implements IEtudiantService {
        EtudiantRepository etudiantRepository;

        @Override
        public List<Etudiant> findAll() {
            return etudiantRepository.findAll();
        }

        @Override
        public Etudiant findById(long id) {
            return etudiantRepository.findById(id).get();
        }

        @Override
        public Etudiant add(Etudiant etudiant) {
            return etudiantRepository.save(etudiant);
        }

        @Override
        public void delete(Etudiant etudiant) {
            etudiantRepository.delete(etudiant);
        }

        @Override
        public Etudiant edit(Etudiant etudiant) {
            return etudiantRepository.save(etudiant);
        }
    }

    Interface:

    public interface IEtudiantService {

        List<Etudiant> findAll();

        Etudiant findById(long id);

        Etudiant add(Etudiant etudiant);

        void delete(Etudiant etudiant);

        Etudiant edit(Etudiant etudiant);
    }

    Controller:

    @Tag(name = "Gestion Etudiant")
    @RestController
    @AllArgsConstructor
    @RequestMapping("/etudiant")
    public class EtudiantController {
        IEtudiantService etudiantService;

        @GetMapping("/index")
        public List<Etudiant> index() {
            return etudiantService.findAll();
        }

        @PostMapping("/add")
        public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
            Etudiant etudiant1 = etudiantService.add(etudiant);
            return etudiant1;
        }

    }

    entity:

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
}

    key words
    and jpql
 {

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findByBlocAndType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    List<Chambre> findByBloc_IdBlocAndTypeC(long idBloc, TypeChambre typeC);

    List<Chambre> findByFoyer_Universite_NomUniversiteAndTypeCAndReservations_AnneeUniversitaireIsNull(
            String nomUniversite, TypeChambre typeChambre);

    List<Chambre> findByNumeroChambreIn(List<Long> numChambre);

    List<Bloc> findByFoyerIdFoyer(Long idFoyer);

    List<Bloc> findByFoyerUniversiteIdUniversite(Long universiteId);

    @Query("SELECT b FROM Bloc b WHERE b.foyer.idFoyer = ?1")
    List<Bloc> findByFoyerIdFoyerJPQL(Long idFoyer);

    @Query(value = "SELECT * FROM Bloc b WHERE b.foyer.idFoyer = ?1", nativeQuery = true)
    List<Bloc> findByFoyerIdFoyerSQL(Long idFoyer);

    @Query("SELECT b FROM Bloc b WHERE b.foyer.universite.idUniversite = ?1")
    List<Bloc> findByFoyerUniversiteIdUniversiteJPQL(Long universiteId);

    @Query(value = "SELECT * FROM Bloc b WHERE b.foyer.universite.idUniversite = ?1", nativeQuery = true)
    List<Bloc> findByFoyerUniversiteIdUniversiteSQL(Long universiteId);

    @Query("SELECT f from Foyer f JOIN Bloc b ON f.idFoyer = b.foyer.idFoyer WHERE b.idBloc = ?1")
    Bloc findFoyerByBlocIdJPQL(Long idBloc);

    @Query(value = "SELECT f.* from Foyer f JOIN Bloc b ON f.idFoyer = b.foyer_id_foyer WHERE b.id_bloc = ?1", nativeQuery = true)
    Bloc findFoyerByBlocIdSQL(Long idBloc);

    @Modifying
    @Query("UPDATE Etudiant e SET e.ecole=?1 WHERE e.idEtudiant < ?2")
    void updateNomUniversiteJPQL(String nomEcole, Long idEtudiant);}

    Controller @Operation(description="recuperer les bloc par nom")@Tag(name="Recherche")

    @GetMapping("getByNom/{nom}")

public ResponseEntity<Bloc> getBlocByNom(@PathVariable String nom) {
    Bloc bloc = blocService.getBlocByNom(nom);
    return bloc != null ? ResponseEntity.ok(bloc) : ResponseEntity.notFound().build();
}

@Operation(description ="recuperer toute les blocs de la base de données")
@Tag(name = "Affichage")

@GetMapping("getAll")
public ResponseEntity<List<Bloc>> getAllBlocs() {
    List<Bloc> blocs = blocService.getAllBlocs();
    return ResponseEntity.ok(blocs);
}

@Operation(description ="faire une mise a jour de la base de données")
@Tag(name = "Mise à jour")

@GetMapping("/byNom")
public List<Bloc> findByNomBloc(@RequestParam String nomBloc) {
    return blocService.findByNomBloc(nomBloc);
}

    ////// delete
    /// @Operation(description ="supprimer bloc")

@Tag(name = "Suppression")

@DeleteMapping("deleteById/{id}")
public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
    blocService.deleteBloc(id);
    return ResponseEntity.noContent().build();
}