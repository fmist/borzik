package cats.borzik.service;

import cats.borzik.exception.BorzikGlobalExceptionHandler;
import cats.borzik.model.Borzik;
import cats.borzik.repo.BorzikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BorzikServiceImpl implements BorzikService {

    private final BorzikRepository borzikRepository;

    @Override
    public List<Borzik> getAll() {
        return borzikRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getById(UUID id) {
        Optional<Borzik> bo = borzikRepository.findById(id);
        if (bo.isEmpty()) {
            throw new BorzikGlobalExceptionHandler.BorzikException("object with id " + id + " is not found");
        }
        return ResponseEntity.ok().body(bo);
    }

    @Override
    public ResponseEntity<?> save(Borzik borzik) {
        return new ResponseEntity<>(borzikRepository.save(borzik), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> edit(UUID id, Borzik borzik) {
        if (borzikRepository.existsById(id)) {
            Borzik newBorzik = borzikRepository.findById(id).orElseThrow();
            newBorzik.setName(borzik.getName());
            newBorzik.setDescription(borzik.getDescription());
            return new ResponseEntity<>(borzikRepository.save(newBorzik), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(borzikRepository.save(borzik), HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<?> delete(UUID id) {
        if (borzikRepository.existsById(id)) {
            borzikRepository.deleteById(id);
            return new ResponseEntity<>("object with id " + id + " is deleted", HttpStatus.OK);
        } else {
            throw new BorzikGlobalExceptionHandler.BorzikException("object with id " + id + " is not found");
        }
    }

    @Override
    public ResponseEntity<?> deleteAll() {
        borzikRepository.deleteAll();
        return new ResponseEntity<>("database cleared", HttpStatus.OK);
    }
}
