package cats.borzik.repo;

import cats.borzik.model.Borzik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorzikRepository extends JpaRepository<Borzik, Long> {
}
