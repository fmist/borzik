package cats.borzik.service;

import cats.borzik.model.Borzik;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BorzikService {
    List<Borzik> getAll();
    ResponseEntity<?> getById(Long id);
    Borzik save(Borzik borzik);
    ResponseEntity<?> edit(Long id, Borzik borzik);
    ResponseEntity<?> delete(Long id);
    void deleteAll();
}
