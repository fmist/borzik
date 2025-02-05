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

@Service
@RequiredArgsConstructor
public class BorzikServiceImpl implements BorzikService {

    private final BorzikRepository borzikRepository;

    @Override
    public List<Borzik> getAll() {
        return borzikRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        Optional<Borzik> bo = borzikRepository.findById(id);
        if (bo.isEmpty()) {
            throw new BorzikGlobalExceptionHandler.BorzikException("Id " + id + " not found");
        }
        return ResponseEntity.ok().body(bo);
    }

    @Override
    public Borzik save(Borzik borzik) {
        return borzikRepository.save(borzik);
    }

    @Override
    public ResponseEntity<?> edit(Long id, Borzik borzik) {
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
    public ResponseEntity<?> delete(Long id) {
        if (borzikRepository.existsById(id)) {
            borzikRepository.deleteById(id);
            return ResponseEntity.ok().body("Id " + id + " deleted");
        } else {
            throw new BorzikGlobalExceptionHandler.BorzikException("Id " + id + " not found");
        }
    }

    @Override
    public void deleteAll() {
        borzikRepository.deleteAll();
    }
}
