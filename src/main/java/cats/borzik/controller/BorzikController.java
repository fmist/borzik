package cats.borzik.controller;

import cats.borzik.model.Borzik;
import cats.borzik.service.BorzikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8081"})
@RequiredArgsConstructor
public class BorzikController {
    private final BorzikService borzikService;

    @GetMapping
    private List<Borzik> getAll() {
        return borzikService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return borzikService.getById(id);
    }

    @PostMapping("/add")
    private ResponseEntity<Borzik> add(@RequestBody Borzik bo) throws URISyntaxException {
        Borzik savedBo = borzikService.save(bo);
        return ResponseEntity.created(new URI("/" + savedBo.getId()))
                .body(savedBo);
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Borzik bo) {
        return borzikService.edit(id, bo);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        return borzikService.delete(id);
    }

    @DeleteMapping("/clear")
    private ResponseEntity<?> clear() {
        borzikService.deleteAll();
        return new ResponseEntity<>("List cleared", HttpStatus.NO_CONTENT);
    }
}
