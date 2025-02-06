package cats.borzik.repo;

import cats.borzik.model.Borzik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BorzikRepository extends JpaRepository<Borzik, UUID> {
}
