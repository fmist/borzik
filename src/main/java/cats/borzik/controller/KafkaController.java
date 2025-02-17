package cats.borzik.controller;

import cats.borzik.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaProducerService producerService;

    @PostMapping("/messages")
    public void sendMessageToKafka(@RequestBody String message) {
        producerService.sendMessage(message);
    }
}
