package cats.borzik.controller;

import cats.borzik.config.KafkaConfig;
import cats.borzik.model.Borzik;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaConfig kafkaConfig;

    @PostMapping(
            value = "/messages",
            consumes = {"application/json"},
            produces = {"application/json"})
    public void postJsonMessage(@RequestBody Borzik borzik) {
        String TOPIC = "borzik-topic";
        kafkaConfig.kafkaTemplate().send(TOPIC, borzik);
    }
}
