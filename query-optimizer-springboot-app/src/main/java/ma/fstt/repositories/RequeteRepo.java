package ma.fstt.repositories;

import ma.fstt.entities.Requete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequeteRepo extends JpaRepository<Requete, Integer> {
}
