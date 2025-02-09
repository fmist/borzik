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
@CrossOrigin(origins = {"http://192.168.50.201:3000"})
@RequiredArgsConstructor
public class BorzikController {
    private final BorzikService borzikService;

    @GetMapping
    private List<Borzik> getAll() {
        return borzikService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable UUID id) {
        return borzikService.getById(id);
    }

    @PostMapping("/add")
    private ResponseEntity<?> add(@RequestBody Borzik bo) throws URISyntaxException {
        return borzikService.save(bo);
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Borzik bo) {
        return borzikService.edit(id, bo);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable UUID id) {
        return borzikService.delete(id);
    }

    @DeleteMapping("/clear")
    private ResponseEntity<?> clear() {
        return borzikService.deleteAll();
    }
}
