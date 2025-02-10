package cats.borzik.controller;

import cats.borzik.model.Borzik;
import cats.borzik.service.BorzikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000"})
public class BorzikController {
    private final BorzikService borzikService;

    @GetMapping
    List<Borzik> getAll() {
        return borzikService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable UUID id) {
        return borzikService.getById(id);
    }

    @PostMapping("/add")
    ResponseEntity<?> add(@RequestBody Borzik bo) {
        return borzikService.save(bo);
    }

    @PutMapping("/edit/{id}")
    ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Borzik bo) {
        return borzikService.edit(id, bo);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable UUID id) {
        return borzikService.delete(id);
    }

    @DeleteMapping("/clear")
    ResponseEntity<?> clear() {
        return borzikService.deleteAll();
    }
}
