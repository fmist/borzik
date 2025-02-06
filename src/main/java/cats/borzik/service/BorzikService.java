package cats.borzik.service;

import cats.borzik.model.Borzik;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface BorzikService {
    List<Borzik> getAll();
    ResponseEntity<?> getById(UUID id);
    ResponseEntity<?> save(Borzik borzik);
    ResponseEntity<?> edit(UUID id, Borzik borzik);
    ResponseEntity<?> delete(UUID id);
    ResponseEntity<?> deleteAll();
}
