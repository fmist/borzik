package cats.borzik.controller;

import cats.borzik.model.Borzik;
import cats.borzik.service.BorzikService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BorzikController {
    public final String TOPIC = "borzik-topic";
    private final BorzikService borzikService;
    private final KafkaTemplate<String, Borzik> kafkaTemplate;

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
        kafkaTemplate.send(TOPIC, bo);
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
